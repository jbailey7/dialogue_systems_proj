#!/Users/brendanraimann/opt/anaconda3/bin/python3

import csv

folder = "data"
year = 2013

teams = [
			["Name", "wins", "losses", "ties", "win percentage", "points for", "points against", "point diff", "avg victory margin", "schedule toughness", "team quality", "offense quality", "defense quality", "Super Bowl Winner", "Super Bowl Loser", "Most Wins", "Most Losses", "Worst Team",	"Strongest Team", "Toughest Schedule", "Easiest Schedule"],
			["Buffalo Bills"],
			["Miami Dolphins"],
			["New England Patriots"],
			["New York Jets"],
			["Pittsburgh Steelers"],
			["Baltimore Ravens"],
			["Cleveland Browns"],
			["Cincinnati Bengals"],
			["Tennessee Titans"],
			["Indianapolis Colts"],
			["Houston Texans"],
			["Jacksonville Jaguars"],
			["Kansas City Chiefs"],
			["Las Vegas Raiders"],
			["Los Angeles Chargers"],
			["Denver Broncos"],
			["Washington Football Team"],
			["New York Giants"],
			["Dallas Cowboys"],
			["Philadelphia Eagles"],
			["Green Bay Packers"],
			["Chicago Bears"],
			["Minnesota Vikings"],
			["Detroit Lions"],
			["New Orleans Saints"],
			["Tampa Bay Buccaneers"],
			["Carolina Panthers"],
			["Atlanta Falcons"],
			["Seattle Seahawks"],
			["Los Angeles Rams"],
			["Arizona Cardinals"],
			["San Francisco 49ers"],
			["Overall"]
		]

file1 = str(folder) + "/" + str(year) + ".csv"
file2 = str(folder) + "/" + str(year) + "-playoffs.csv"
outfile = str(folder) + "/" + str(year) + "-cleaned.csv"

#Populating team-specific statistics
with open(file1) as csv_file:
	csv_reader = csv.reader(csv_file, delimiter=',')
	first_line = True
	for row in csv_reader:
		if first_line:
			first_line = False
		else:
			index = -1

			if "Bills" in row[0]: 	  	index = 0
			if "Dolphins" in row[0]: 	index = 1
			if "Patriots" in row[0]: 	index = 2
			if "Jets" in row[0]: 	 	index = 3
			if "Steelers" in row[0]:  	index = 4
			if "Ravens" in row[0]: 		index = 5
			if "Browns" in row[0]: 		index = 6
			if "Bengals" in row[0]: 	index = 7

			if "Titans" in row[0]: 	  	index = 8
			if "Colts" in row[0]: 		index = 9
			if "Texans" in row[0]: 		index = 10
			if "Jaguars" in row[0]: 	index = 11
			if "Chiefs" in row[0]:  	index = 12
			if "Raiders" in row[0]: 	index = 13
			if "Chargers" in row[0]: 	index = 14
			if "Broncos" in row[0]: 	index = 15

			if "Washington" in row[0]: 	index = 16
			if "Giants" in row[0]: 		index = 17
			if "Cowboys" in row[0]: 	index = 18
			if "Eagles" in row[0]: 		index = 19
			if "Packers" in row[0]:  	index = 20
			if "Bears" in row[0]: 		index = 21
			if "Vikings" in row[0]: 	index = 22
			if "Lions" in row[0]: 		index = 23

			if "Saints" in row[0]: 		index = 24
			if "Buccaneers" in row[0]: 	index = 25
			if "Panthers" in row[0]: 	index = 26
			if "Falcons" in row[0]: 	index = 27
			if "Seahawks" in row[0]:  	index = 28
			if "Rams" in row[0]: 		index = 29
			if "Cardinals" in row[0]: 	index = 30
			if "Francisco" in row[0]: 	index = 31

			index += 1

			teams[index] = [teams[index][0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], row[10], row[11], row[12], 0, 0, 0, 0, 0, 0, 0, 0]


#check most wins, most losses, best team, worst team, toughest schedule, easiest schedule
most_wins = 0
most_losses = 0
best_team = 0.0
worst_team = 0.0
toughest_schedule = 0.0
easiest_schedule = 0.0

wlbw = ["--Empty--"] * 6 #data structure for overall team stats

for i in range (1, 32):
	if int(teams[i][1]) > most_wins:
		most_wins = int(teams[i][1])
		wlbw[0] = teams[i][0]
	
	if int(teams[i][2]) > most_losses:
		most_losses = int(teams[i][2])
		wlbw[1] = teams[i][0]

	if float(teams[i][10]) > best_team:
		best_team = float(teams[i][10])
		wlbw[2] = teams[i][0]

	if float(teams[i][10]) < worst_team:
		worst_team = float(teams[i][10])
		wlbw[3] = teams[i][0]

	if float(teams[i][9]) > toughest_schedule:
		toughest_schedule = float(teams[i][9])
		wlbw[4] = teams[i][0]

	if float(teams[i][9]) < easiest_schedule:
		easiest_schedule = float(teams[i][9])
		wlbw[5] = teams[i][0]



#Populating overall statistics
with open(file2) as csv_file:
	csv_reader = csv.reader(csv_file, delimiter=',')
	first_line = True
	for row in csv_reader:
		if "Super" in row[0] or "super" in row[0]:
			teams[33] = [teams[33][0], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, row[3], row[5], wlbw[0], wlbw[1], wlbw[3], wlbw[2], wlbw[4], wlbw[5]]

#writing to compiled csv datafile for this given year
with open(outfile,"w+") as my_csv:
    csvWriter = csv.writer(my_csv,delimiter=',')
    csvWriter.writerows(teams)



print("Processed " + str(year) + " data into the file " + outfile + ".")





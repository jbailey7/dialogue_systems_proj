import os
import re
import random
import numpy as np
from collections import defaultdict
from keras.preprocessing.text import Tokenizer
from sklearn.feature_extraction.text import TfidfTransformer
import keras

from keras.preprocessing.sequence import pad_sequences
from keras import backend as K
from keras.utils import to_categorical
import tensorflow as tf
from keras.models import Sequential
from keras.layers import Activation, Dense, Dropout, LSTM, Embedding, Conv1D, Masking, Flatten

random.seed(1337)
np.random.seed(1337)
tf.random.set_seed(1337)


vocab_size = 10000
EMBEDDING_DIM = 100
MAX_SEQUENCE_LENGTH = 1000


dat = list()
cat = list()

filename = 'data/LeagueQuestions.csv'
types = ['team:bestteam', 'team:mostlosses', 'team:mostwins', 'team:superbowlloser', 'team:superbowlwinner', 'team:worstteam']

with open(filename) as datfile: 
	for i, line in enumerate(datfile): 
		dattext = line.replace('\n', ' ')
		dattext = re.sub('[^0-9a-zA-Z]+', ' ', dattext)
		dattext = dattext.lower()
            
		dat.append(dattext)
		cat.append(int(i/3))

#print(cat)





temp = list(zip(cat, dat))
random.shuffle(temp)
cat, dat = zip(*temp)

trainlen = int(len(cat) * 0.80)
vallen = int(len(cat) * 0.10)
testlen = int(len(cat) * 0.10)

traindat = dat[:trainlen]
valdat = dat[trainlen:trainlen+vallen]
testdat = dat[trainlen+vallen:]

traincat = cat[:trainlen]
valcat = cat[trainlen:trainlen+vallen]
testcat = cat[trainlen+vallen:]

#tokenizer = Tokenizer(filters='', lower=False, num_words=vocab_size, oov_token="UNK")
tokenizer = Tokenizer(num_words=vocab_size, oov_token="UNK")
tokenizer.fit_on_texts(traindat)

#Xtrain = tokenizer.texts_to_matrix(traindat, mode='freq')
Ytrain = np.asarray(traincat)

Yval = np.asarray(valcat)

#Xtest = tokenizer.texts_to_matrix(testdat, mode='freq')
Ytest = np.asarray(testcat)

#tfidf_transformer = TfidfTransformer(use_idf=True).fit(Xtrain)
#Xtrain = tfidf_transformer.transform(Xtrain)

word_index = tokenizer.word_index

#tfidf_transformer = TfidfTransformer(use_idf=True).fit(Xtest)
#Xtest = tfidf_transformer.transform(Xtest)

Xtrain = tokenizer.texts_to_sequences(traindat)
Xval = tokenizer.texts_to_sequences(valdat)
Xtest = tokenizer.texts_to_sequences(testdat)

text_maxlen = 200
num_classes = 6
vector_size = 100
batch_size = 1

Xtrain = pad_sequences(Xtrain, padding="post", truncating="post", maxlen=text_maxlen)
Xval = pad_sequences(Xval, padding="post", truncating="post", maxlen=text_maxlen)
Xtest = pad_sequences(Xtest, padding="post", truncating="post", maxlen=text_maxlen)

Ytrain = to_categorical(Ytrain, num_classes=num_classes)
Yval = to_categorical(Yval, num_classes=num_classes)
Ytest = to_categorical(Ytest, num_classes=num_classes)


print(Xtrain.shape)
print(Xtest.shape)

print(Ytrain.shape)
print(Ytest.shape)


from tensorflow.keras.layers.experimental.preprocessing import TextVectorization

#word_index = Tokenizer.word_index

embeddings_index = {}
f = open(os.path.join('data/', 'glove.6B.100d.txt'))
for line in f: 
	values = line.split()
	word = values[0]
	coefs = np.asarray(values[1:], dtype='float32')
	embeddings_index[word] = coefs
f.close()




embedding_matrix = np.zeros((len(word_index) + 1, EMBEDDING_DIM))
hits = 0
misses = 0
for word, i in word_index.items(): 
	embedding_vector = embeddings_index.get(word)
	if embedding_vector is not None: 
		embedding_matrix[i] = embedding_vector
		hits += 1
	else: 
		misses += 1

model = Sequential()



embedding_layer = Embedding(
			len(word_index) + 1, 
			EMBEDDING_DIM, 
			embeddings_initializer=keras.initializers.Constant(embedding_matrix), 
			trainable=False,
			input_length=text_maxlen
)

#model.add(embedding_layer)
model.add(Embedding(vocab_size, vector_size, input_length=text_maxlen))
model.add(LSTM(vector_size, return_sequences=True))
model.add(Flatten())
model.add(Dense(num_classes, activation='softmax'))

model.summary()

#reinstall in model later
#model.add(Dropout(0.3))

model.compile(loss='categorical_crossentropy',
              optimizer='adam',
              metrics=['accuracy'])

K.set_value(model.optimizer.learning_rate, 0.001)

history = model.fit(Xtrain, Ytrain,
                    batch_size=batch_size,
					epochs=12,
                    verbose=1,
                    validation_data=(Xval, Yval))

model.summary()

'''
Ypred = model.predict(Xtest)



Ypred = np.argmax(Ypred, axis=1)
Ytest = np.argmax(Ytest, axis=1)


print(Ytest)
print()
print(Ypred)
print()
print(testdat)


specific_types = ['desc:room','desc:located','desc:find','desc:shared','desc:parking']



from sklearn import metrics
print(metrics.classification_report(Ytest, Ypred, target_names=specific_types))

cm = metrics.confusion_matrix(Ytest, Ypred).transpose()

np.set_printoptions(linewidth=500)
np.set_printoptions(threshold=np.inf)

print(cm)

'''
model.save('league_lstm.h5')
#tf.keras.models.save_model(model, 'qa_g_lstm.h5')
tokenizer_json = tokenizer.to_json()
with open('league_tok.json', 'w', encoding='utf-8') as f:
	f.write(tokenizer_json)









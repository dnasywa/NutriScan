# Machine Learning
## Steps to Generate Model
1. Open Google Colaboratory notebook, refer to this [notebook](https://github.com/dnasywa/NutriScan/blob/main/Machine%20Learning/capstone_RGB_model_and_recomendation.ipynb) as baseline implementation with Convolutional Neural and Long Short Term Memory Network.
2. Clone the [dataset](https://github.com/dnasywa/NutriScan/blob/main/Machine%20Learning/Dataset) and adjust the directory paths. Make sure of the hierarchy. 
```
$ git clone https://github.com/dnasywa/NutriScan/tree/main/Machine%20Learning/Dataset
```
4. After training, save the model. You can save it into Keras hdf5 file and convert it into TensorFlow Lite format which has a .tflite file format extension through several optimization processes.
## Featured Technologies
- TensorFlow: The core open source library to help you develop and train ML models. Get started quickly by running Colab notebooks directly in your browser.
- Keras: Keras is a deep learning API written in Python, running on top of the machine learning platform TensorFlow.
- TensorFlow Lite: TensorFlow Lite is an open source deep learning framework for on-device inference.

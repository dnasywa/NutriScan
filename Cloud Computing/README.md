# Nutri Scan APP
Cloud Computing API bulid connect to machine learning model

# Machine Learning API on Cloud Build

### 1. Write the Flask server app using Python
Save the model in '.h5' format in the same directory as main.py
Load the model and write Flask code in main.py
Test the Flask server locally by running main.py, copy the assigned local URL to test.py then run it with test images.
### 2. Setup Google Cloud
Enable Cloud Run and Cloud Build API
### 3. Install and init Google Cloud SDK
https://cloud.google.com/sdk/docs/install
### 4. Dockerfile, requirements.txt, .dockerignore
https://cloud.google.com/run/docs/quickstarts/build-and-deploy#containerizing
### 5. Deploy In Cloud Run
Set several things such as Instance, Port, and other resources, then start deploy with Cloud Run
### Test
Test the code using https://nutriscan-rvpj3e3pka-uc.a.run.app/predict in postman and upload the image file

# Weather Forecast Application

## 🌦️ Project Description
The Weather Forecast application allows users to retrieve weather forecasts for the next 7 days for a selected geographical location and estimate the generated energy using photovoltaic installations based on these forecasts.

## ⚙️ Technologies Used
### Backend:
- Java
- Spring Boot
- Docker
- Integration with external API [Open Meteo](https://open-meteo.com/en/docs)

### Frontend:
- HTML
- JavaScript
- Leaflet.js (optional)
- Font Awesome (for displaying weather icons)
- Responsive design (optional)

### Deploy:
- Render.com

## 🚀 Features
### Backend:
- Provides an endpoint for retrieving weather forecasts based on latitude and longitude.
- Calculates the estimated amount of energy generated in kWh based on weather data.
- Validates data received from the client and data types.

### Frontend:
- Displays a table with weather forecasts for the next 7 days for the current location or a location selected by the user.
- Utilizes weather icons to illustrate atmospheric conditions.
- Presents the maximum and minimum temperature for each day.
- Shows the estimated amount of energy generated in kWh.

## 🌍 Additional Features
- World map with the ability to select a location.
- Automatic retrieval of latitude and longitude based on the map location.

## 📦 Deployment
1. Created a Dockerfile in the main directory of the backend repository.
2. Created a new Web Service on Render.com and connected it to the repository (GitHub).
3. Set the runtime to Docker.

## 🔗 Project Links
1. Backend repository: [link](https://github.com/StrADaMi/weather-backend)
2. Frontend repository: [link](https://github.com/StrADaMi/weather-frontend)
3. Access to the deployed application: [link](https://weather-frontend-o4rv.onrender.com/)

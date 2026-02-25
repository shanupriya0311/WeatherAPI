<h1>Weather API</h1>
<br>
A Spring Boot REST API that imports weather data from a CSV file, stores it in MongoDB, and provides monthly weather records and temperature statistics.
<br>
🚀Key Features
<br>

⚡Upload CSV file and save weather data to MongoDB

⚡Fetch weather data by month

⚡Get temperature statistics (max / median / min)

⚡Handles custom datetime format (yyyyMMdd-HH:mm)

⚡Handles empty numeric fields safely

⚡Multipart file upload support
<br>

🛠 Technology Stack
Java 21
Spring Boot
Spring Data MongoDB
OpenCSV
MongoDB
Postman (for testing)

📁 Project Structure
<img width="386" height="823" alt="image" src="https://github.com/user-attachments/assets/bab21d0e-697b-483f-b1b2-e7f95b1f380d" />

▶️ Run the Application
mvn spring-boot:run
Server runs on:
http://localhost:8076

🌐 API Endpoints
POST:
http://localhost:8076/weather/import
<img width="1600" height="556" alt="image" src="https://github.com/user-attachments/assets/d54ec711-b38e-4af9-bb8e-161b36410d6c" />

📊Get Weather Data by Month
http://localhost:8076/weather/stats?year=1996&month=11
<img width="1062" height="849" alt="image" src="https://github.com/user-attachments/assets/60a51a3e-d745-420a-b31f-aeb6a121bb39" />

📊 Get Temperature Statistics
http://localhost:8076/weather/stats?year=1996&month=11
<img width="656" height="593" alt="image" src="https://github.com/user-attachments/assets/0d92a5a1-9fb9-4c60-b72a-66771b212e21" />



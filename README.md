<h1>Weather API</h1>
<br>
A Spring Boot REST API that imports weather data from a CSV file, stores it in MongoDB, and provides monthly weather records and temperature statistics.
<br>

<h2>🚀Key Features</h2>
<br>

⚡Upload CSV file and save weather data to MongoDB

⚡Fetch weather data by month

⚡Get temperature statistics (max / median / min)

⚡Handles custom datetime format (yyyyMMdd-HH:mm)

⚡Handles empty numeric fields safely

⚡Multipart file upload support
<br>

<h2>🛠 Technology Stack</h2>
<br>
Java 21<br>
Spring Boot<br>
Spring Data MongoDB<br>
OpenCSV<br>
MongoDB<br>
Postman (for testing)
<br>
<h2>📁 Project Structure</h2>
<img width="386" height="823" alt="image" src="https://github.com/user-attachments/assets/bab21d0e-697b-483f-b1b2-e7f95b1f380d" />
<br>
<h2>▶️ Run the Application</h2>
mvn spring-boot:run
Server runs on:
http://localhost:8076

<h2>🌐 API Endpoints</h2>
POST:
http://localhost:8076/weather/import
<img width="1600" height="556" alt="image" src="https://github.com/user-attachments/assets/d54ec711-b38e-4af9-bb8e-161b36410d6c" />

📊Get Weather Data by Month
http://localhost:8076/weather/stats?year=1996&month=11
<img width="1062" height="849" alt="image" src="https://github.com/user-attachments/assets/60a51a3e-d745-420a-b31f-aeb6a121bb39" />

📊 Get Temperature Statistics
http://localhost:8076/weather/stats?year=1996&month=11
<img width="656" height="593" alt="image" src="https://github.com/user-attachments/assets/0d92a5a1-9fb9-4c60-b72a-66771b212e21" />



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
<br>
<h2>POST:Posting the CSV file</h2>
<br>
<img width="1600" height="556" alt="image" src="https://github.com/user-attachments/assets/d54ec711-b38e-4af9-bb8e-161b36410d6c" />
<br>
<h2>📊Get Weather Data by Month</h2>
<br>
<img width="1007" height="977" alt="image" src="https://github.com/user-attachments/assets/c8ea1a68-bfa8-45c1-be8b-6101fcf45b5f" />

<br>
<h2>📊 Get Temperature Statistics</h2>
<br>
<img width="869" height="882" alt="image" src="https://github.com/user-attachments/assets/97ba1f58-6a37-40a3-9118-baae1e012795" />




<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hospital Management - Patients</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Hospital Management - Patients</h1>

    <form id="addPatientForm">
        <input type="text" name="name" placeholder="Patient Name" required>
        <input type="number" name="age" placeholder="Age" required>
        <select name="gender" required>
            <option value="">Select Gender</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select>
        <input type="text" name="contact" placeholder="Contact Number">
        <textarea name="address" placeholder="Address"></textarea>
        <button type="submit">Add Patient</button>
    </form>

    <h2>Patient List</h2>
    <table id="patientsTable">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Contact</th>
                <th>Address</th>
                <th>Registered On</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>

    <script>
        document.getElementById('addPatientForm').addEventListener('submit', function (e) {
            e.preventDefault();

            const formData = new FormData(this);
            fetch('add_patient.php', {
                method: 'POST',
                body: formData
            })
            .then(response => response.text())
            .then(data => {
                alert(data);
                fetchPatients();
            })
            .catch(error => console.error('Error:', error));
        });

        function fetchPatients() {
            fetch('get_patients.php')
                .then(response => response.json())
                .then(data => {
                    const tableBody = document.querySelector('#patientsTable tbody');
                    tableBody.innerHTML = '';
                    data.forEach(patient => {
                        tableBody.innerHTML += `
                            <tr>
                                <td>${patient.id}</td>
                                <td>${patient.name}</td>
                                <td>${patient.age}</td>
                                <td>${patient.gender}</td>
                                <td>${patient.contact}</td>
                                <td>${patient.address}</td>
                                <td>${patient.created_at}</td>
                            </tr>
                        `;
                    });
                })
                .catch(error => console.error('Error:', error));
        }

        fetchPatients();
    </script>
</body>
</html>

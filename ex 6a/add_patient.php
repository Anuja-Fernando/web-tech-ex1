<?php
// Handle form submission
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Check if the form fields are set before accessing them
    $name = isset($_POST['name']) ? $_POST['name'] : '';
    $age = isset($_POST['age']) ? $_POST['age'] : '';
    $gender = isset($_POST['gender']) ? $_POST['gender'] : '';
    $contact = isset($_POST['contact']) ? $_POST['contact'] : '';
    $address = isset($_POST['address']) ? $_POST['address'] : '';

    // Check if all required fields are filled
    if ($name && $age && $gender && $contact && $address) {
        // Connect to the database
        $conn = new mysqli('localhost', 'root', '', 'hospital_db');

        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }

        // Insert data into the patients table
        $sql = "INSERT INTO patients (name, age, gender, contact, address) VALUES ('$name', '$age', '$gender', '$contact', '$address')";

        if ($conn->query($sql) === TRUE) {
            echo "New patient added successfully.<br>";
        } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
        }

        $conn->close();
    } else {
        echo "All fields are required.";
    }
}

// Display all patients
$conn = new mysqli('localhost', 'root', '', 'hospital_db');

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT * FROM patients";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo "<h2>Patient List</h2>";
    echo "<table border='1' cellspacing='0' cellpadding='10'>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Contact</th>
                <th>Address</th>
            </tr>";
    while ($row = $result->fetch_assoc()) {
        echo "<tr>
                <td>" . $row['id'] . "</td>
                <td>" . $row['name'] . "</td>
                <td>" . $row['age'] . "</td>
                <td>" . $row['gender'] . "</td>
                <td>" . $row['contact'] . "</td>
                <td>" . $row['address'] . "</td>
              </tr>";
    }
    echo "</table>";
} else {
    echo "No patients found.";
}

$conn->close();
?>

<!-- HTML Form -->
<h2>Add New Patient</h2>
<form action="add_patient.php" method="POST">
    <input type="text" name="name" placeholder="Name" required>
    <input type="number" name="age" placeholder="Age" required>
    <input type="radio" name="gender" value="male" required> Male
    <input type="radio" name="gender" value="female" required> Female
    <input type="text" name="contact" placeholder="Contact" required>
    <input type="text" name="address" placeholder="Address" required>
    <input type="submit" value="Add Patient">
</form>

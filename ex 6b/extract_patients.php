<?php
$xml = simplexml_load_file('patients.xml') or die("Error: Cannot load XML file");

echo "<h2>Hospital Patient List</h2>";
echo "<table border='1' cellspacing='0' cellpadding='10'>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Contact</th>
            <th>Address</th>
        </tr>";

foreach ($xml->patients->patient as $patient) {
    echo "<tr>
            <td>" . $patient->id . "</td>
            <td>" . $patient->name . "</td>
            <td>" . $patient->age . "</td>
            <td>" . $patient->gender . "</td>
            <td>" . $patient->contact . "</td>
            <td>" . $patient->address . "</td>
          </tr>";
}

echo "</table>";
?>

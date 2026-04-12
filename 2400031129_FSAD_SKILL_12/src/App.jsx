import React, { useState, useEffect } from "react";

const App = () => {
  const [empid, setEmpid] = useState("");
  const [ename, setEname] = useState("");
  const [salary, setSalary] = useState("");
  const [empActive, setEmpActive] = useState(false);
  const [employees, setEmployees] = useState([]);
  const [searchId, setSearchId] = useState("");
  const [foundEmployee, setFoundEmployee] = useState(null);
  const [deleteId, setDeleteId] = useState("");

  //=================================
  //GET - EMPLOYEE BY ID
  //=================================
  const getEmpById = () => {
    fetch(`http://localhost:8081/emp/${searchId}`)
    .then(response => {
      if(!response.ok) {
        throw new Error("Employee not found");
      }
      return response.json();
    })
    .then(data => {
       setFoundEmployee(data);
    })
       .catch(error => {
        console.error("Error fetching employee:", error);
         setFoundEmployee(null);
    });
  };

  //==================================
  // Load Employees
  //==================================
  const loadEmployees = () => {
    fetch("http://localhost:8081/emp/all")
      .then(res => res.json())
      .then(data => setEmployees(data))
      .catch(err => console.log(err));
  };

  //==================================
  // GET - Fetch employees
  //==================================
  useEffect(() => {
    loadEmployees();
  }, []);

  //==================================
  // POST - Save employee
  //==================================
  const saveEmployees = () => {

    const employeeData = {
      empid: parseInt(empid),
      ename: ename,
      salary: parseFloat(salary),
      empActive: empActive
    };

    fetch("http://localhost:8081/emp/save", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(employeeData)
    })
      .then(response => response.json())
      .then(message => {
        alert(message);
        clearForm();
        loadEmployees();   // refresh table automatically
      })
      .catch(error => console.log(error));
  };

  //==================================
  // Clear Form
  //==================================
  const clearForm = () => {
    setEmpid("");
    setEname("");
    setSalary("");
    setEmpActive(false);
  };

  //=================================
  //Delete Employee By ID
  //=================================
  const deleteEmployee = () => {
    fetch(`http://localhost:8081/emp/${deleteId}`, {
    method: "DELETE"
  })
    .then(response => response.text())
    .then(data => {
      alert(data);        // display success message
      setDeleteId("");    // clear input
      loadEmployees();    // refresh table
    })
    .catch(error => console.log(error));  
  };

  return (
    <div style={{ padding: "20px" }}>

    <h2>Delete Employee By ID</h2>
    <input 
      type="number" 
      placeholder="Enter Employee ID to delete"  
      value={deleteId} 
      onChange={e => setDeleteId(e.target.value)} 
    />
    <button onClick={deleteEmployee}>Delete</button>
    <br /><br />

      <h2>Search Employee By ID</h2>
      <input 
        type="number" 
        placeholder="Enter Employee ID to search" 
        value={searchId} 
        onChange={e => setSearchId(e.target.value)} 
      />

      <button onClick={getEmpById}>Search</button>
      <br /><br />
      {foundEmployee && ( 
        <div>
          <h2>Found Employee</h2>
          <p>Employee ID: {foundEmployee.empid} </p>
          <p>Employee Name: {foundEmployee.ename}</p>
          <p>Employee Salary: {foundEmployee.salary}</p>
          <p>Employee Active Status: {foundEmployee.empActive ? "Active" : "Inactive"}</p>
        </div>
      )}

      <h2>Enter Employee Details:</h2>

      {/* Employee ID */}
      <input
        type="number"
        placeholder="Employee ID"
        value={empid}
        onChange={e => setEmpid(e.target.value)}
      />
      <br /><br />

      {/* Employee Name */}
      <input
        type="text"
        placeholder="Employee Name"
        value={ename}
        onChange={e => setEname(e.target.value)}
      />
      <br /><br />

      {/* Employee Salary */}
      <input
        type="number"
        placeholder="Employee Salary"
        value={salary}
        onChange={e => setSalary(e.target.value)}
      />
      <br /><br />

      {/* Employee Status */}
      <label>
        Employee Active Status:
        <input
          type="checkbox"
          checked={empActive}
          onChange={e => setEmpActive(e.target.checked)}
        />
      </label>

      <br /><br />

      <button onClick={saveEmployees}>Save Employee</button>

      <br /><br />

      <h2>Employee List - From MySQL</h2>
      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Employee Salary</th>
            <th>Employee Active Status</th>
          </tr>
        </thead>

        <tbody>
          {Array.isArray(employees) &&
            employees.map(i => (
              <tr key={i.empid}>
                <td>{i.empid}</td>
                <td>{i.ename}</td>
                <td>{i.salary}</td>
                <td>{i.empActive ? "Yes" : "No"}</td>
              </tr>
            ))}
        </tbody>
      </table>

    </div>
  );
};

export default App;
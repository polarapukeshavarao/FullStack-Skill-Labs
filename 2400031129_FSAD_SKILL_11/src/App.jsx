import React, { useState, useEffect } from "react";
import Login from "./Login";

/* ================================
   EMPLOYEE APP (YOUR OLD CODE)
================================ */
const EmployeeApp = ({ onLogout }) => {

  const [empid, setEmpid] = useState("");
  const [ename, setEname] = useState("");
  const [salary, setSalary] = useState("");
  const [empActive, setEmpActive] = useState(false);
  const [employees, setEmployees] = useState([]);
  const [searchId, setSearchId] = useState("");
  const [foundEmployee, setFoundEmployee] = useState(null);
  const [deleteId, setDeleteId] = useState("");

  const getEmpById = () => {
    fetch(`http://localhost:8081/emp/${searchId}`)
      .then(response => {
        if (!response.ok) throw new Error("Employee not found");
        return response.json();
      })
      .then(data => setFoundEmployee(data))
      .catch(() => setFoundEmployee(null));
  };

  const loadEmployees = () => {
    fetch("http://localhost:8081/emp/all")
      .then(res => res.json())
      .then(data => setEmployees(data));
  };

  useEffect(() => {
    loadEmployees();
  }, []);

  const saveEmployees = () => {
    const employeeData = {
      empid: parseInt(empid),
      ename,
      salary: parseFloat(salary),
      empActive
    };

    fetch("http://localhost:8081/emp/save", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(employeeData)
    })
      .then(res => res.json())
      .then(msg => {
        alert(msg);
        clearForm();
        loadEmployees();
      });
  };

  const clearForm = () => {
    setEmpid("");
    setEname("");
    setSalary("");
    setEmpActive(false);
  };

  const deleteEmployee = () => {
    fetch(`http://localhost:8081/emp/${deleteId}`, {
      method: "DELETE"
    })
      .then(res => res.text())
      .then(msg => {
        alert(msg);
        setDeleteId("");
        loadEmployees();
      });
  };

  return (
    <div style={{ padding: "20px" }}>

      {/* LOGOUT BUTTON */}
      <button onClick={onLogout}>Logout</button>

      <h2>Delete Employee</h2>
      <input value={deleteId} onChange={e => setDeleteId(e.target.value)} />
      <button onClick={deleteEmployee}>Delete</button>

      <h2>Search Employee</h2>
      <input value={searchId} onChange={e => setSearchId(e.target.value)} />
      <button onClick={getEmpById}>Search</button>

      {foundEmployee && (
        <div>
          <p>{foundEmployee.ename}</p>
        </div>
      )}

      <h2>Add Employee</h2>
      <input placeholder="ID" value={empid} onChange={e => setEmpid(e.target.value)} />
      <input placeholder="Name" value={ename} onChange={e => setEname(e.target.value)} />
      <input placeholder="Salary" value={salary} onChange={e => setSalary(e.target.value)} />

      <label>
        Active:
        <input type="checkbox" checked={empActive} onChange={e => setEmpActive(e.target.checked)} />
      </label>

      <button onClick={saveEmployees}>Save</button>

      <h2>All Employees</h2>
      <table border="1">
        <thead>
          <tr>
            <th>ID</th><th>Name</th><th>Salary</th><th>Status</th>
          </tr>
        </thead>
        <tbody>
          {employees.map(e => (
            <tr key={e.empid}>
              <td>{e.empid}</td>
              <td>{e.ename}</td>
              <td>{e.salary}</td>
              <td>{e.empActive ? "Yes" : "No"}</td>
            </tr>
          ))}
        </tbody>
      </table>

    </div>
  );
};

/* ================================
   MAIN APP (LOGIN CONTROL)
================================ */
const App = () => {

  const [isLoggedIn, setIsLoggedIn] = useState(
    localStorage.getItem("user") !== null
  );

  return (
    <>
      {isLoggedIn ? (
        <EmployeeApp
          onLogout={() => {
            localStorage.removeItem("user");
            setIsLoggedIn(false);
          }}
        />
      ) : (
        <Login onLogin={() => setIsLoggedIn(true)} />
      )}
    </>
  );
};

export default App;
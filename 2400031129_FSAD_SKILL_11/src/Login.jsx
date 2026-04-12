import { useState } from "react";

const Login = ({ onLogin }) => {

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = () => {
    fetch("http://localhost:8081/auth/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ username, password })
    })
      .then(res => res.text())
      .then(data => {
        alert(data);

        if (data === "Login Successful") {
          localStorage.setItem("user", username);

          onLogin();   // 🔥 THIS LINE FIXES YOUR ISSUE
        }
      })
      .catch(err => console.log(err));
  };

  return (
    <div style={{
      height: "100vh",
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
      backgroundColor: "#1e1e1e"
    }}>

      <div style={{
        background: "#2c2c2c",
        padding: "40px",
        borderRadius: "10px",
        width: "300px",
        textAlign: "center",
        boxShadow: "0 0 10px rgba(0,0,0,0.5)"
      }}>

        <h2 style={{ color: "white" }}>Login</h2>

        <input
          type="text"
          placeholder="Enter Username"
          value={username}
          onChange={e => setUsername(e.target.value)}
          style={{
            width: "100%",
            padding: "10px",
            margin: "10px 0",
            borderRadius: "5px",
            border: "1px solid #ccc"
          }}
        />

        <input
          type="password"
          placeholder="Enter Password"
          value={password}
          onChange={e => setPassword(e.target.value)}
          style={{
            width: "100%",
            padding: "10px",
            margin: "10px 0",
            borderRadius: "5px",
            border: "1px solid #ccc"
          }}
        />

        <button
          onClick={handleLogin}
          style={{
            width: "100%",
            padding: "10px",
            marginTop: "10px",
            backgroundColor: "#4CAF50",
            color: "white",
            border: "none",
            borderRadius: "5px",
            cursor: "pointer",
            fontWeight: "bold"
          }}
        >
          Login
        </button>

      </div>
    </div>
  );
};

export default Login;
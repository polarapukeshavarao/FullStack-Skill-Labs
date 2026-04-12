import { useState } from "react";
import { loginUser } from "./auth";

const Login = ({ onLogin }) => {

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = () => {
    const success = loginUser(username, password);

    if (success) {
      alert("Login Successful");
      onLogin();   // redirect
    } else {
      alert("Invalid Credentials");
    }
  };

  return (
    <div style={{ textAlign: "center", marginTop: "100px" }}>
      <h2>Login</h2>

      <input
        placeholder="Username"
        onChange={e => setUsername(e.target.value)}
      />
      <br /><br />

      <input
        type="password"
        placeholder="Password"
        onChange={e => setPassword(e.target.value)}
      />
      <br /><br />

      <button onClick={handleLogin}>Login</button>
    </div>
  );
};

export default Login;
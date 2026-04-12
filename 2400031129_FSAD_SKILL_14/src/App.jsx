import { useState } from "react";
import Login from "./Login";
import Dashboard from "./Dashboard";
import { isAuthenticated, logoutUser } from "./auth";

function App() {

  const [loggedIn, setLoggedIn] = useState(isAuthenticated());

  return (
    <div>

      {loggedIn ? (
        <>
          <button onClick={() => {
            logoutUser();
            setLoggedIn(false);
          }}>
            Logout
          </button>

          <Dashboard />
        </>
      ) : (
        <Login onLogin={() => setLoggedIn(true)} />
      )}

    </div>
  );
}

export default App;
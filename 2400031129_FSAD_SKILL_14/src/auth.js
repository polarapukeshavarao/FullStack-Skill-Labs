export const loginUser = (username, password) => {
  // fake validation
  if (username === "admin" && password === "1234") {
    localStorage.setItem("user", username);
    return true;
  }
  return false;
};

export const logoutUser = () => {
  localStorage.removeItem("user");
};

export const isAuthenticated = () => {
  return localStorage.getItem("user") !== null;
};
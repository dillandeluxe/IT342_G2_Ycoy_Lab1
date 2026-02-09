import { useNavigate } from "react-router-dom";

function Dashboard({ onLogout }) {
  const navigate = useNavigate();
  const handleLogout = () => {
    onLogout();
    navigate("/login");
  };

  return (
    <div style={{ padding: "50px", textAlign: "center" }}>
      <h1>🎉 Welcome to the Dashboard!</h1>
      <p>You have successfully logged in.</p>
      <button onClick={handleLogout} style={{ marginTop: "20px" }}>Logout</button>
    </div>
  );
}

export default Dashboard;
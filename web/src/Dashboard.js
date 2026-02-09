import { useNavigate } from "react-router-dom";
import "./Dashboard.css";

function Dashboard({ onLogout }) {
  const navigate = useNavigate();
  const handleLogout = () => {
    onLogout();
    navigate("/login");
  };

  return (
    <div className="dashboard-container">
      <header className="dashboard-header">
        <nav className="dashboard-nav">
          <h1 className="dashboard-logo">UserAuth</h1>
          <button className="logout-button" onClick={handleLogout}>Logout</button>
        </nav>
      </header>
      
      <div className="dashboard-content">
        <div className="dashboard-welcome">
          <h1 className="dashboard-title">🎉 Welcome!</h1>
          <p className="dashboard-subtitle">You have successfully logged in to your account. Your authentication system is working perfectly!</p>
        </div>
      </div>
    </div>
  );
}

export default Dashboard;
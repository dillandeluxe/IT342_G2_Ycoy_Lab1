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
          <div className="nav-tabs">
            <span className="nav-tab active">Dashboard</span>
            <span className="nav-tab profile-tab">Profile</span>
          </div>
          <button className="logout-button" onClick={handleLogout}>Logout</button>
        </nav>
      </header>
      
      <div className="dashboard-content">
        <div className="dashboard-welcome">
          <h1 className="dashboard-title">Welcome!</h1>
          <p className="dashboard-subtitle">yey</p>
        </div>
      </div>
    </div>
  );
}

export default Dashboard;
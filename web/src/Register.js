import { useState } from "react";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";
import "./Register.css";

function Register() {
  const [formData, setFormData] = useState({ firstName: "", lastName: "", username: "", email: "", password: "" });
  const navigate = useNavigate();

  const handleChange = (e) => setFormData({ ...formData, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8080/api/auth/register", formData);
      alert("Registration Successful!");
      navigate("/login");
    } catch (error) {
      alert("Error registering user");
    }
  };

  return (
    <div className="register-container">
      <div className="register-card">
        <h2 className="register-title">Create Account</h2>
        <form className="register-form" onSubmit={handleSubmit}>
          <input className="form-input" name="firstName" placeholder="First Name" onChange={handleChange} required />
          <input className="form-input" name="lastName" placeholder="Last Name" onChange={handleChange} required />
          <input className="form-input" name="username" placeholder="Username" onChange={handleChange} required />
          <input className="form-input" name="email" placeholder="Email" type="email" onChange={handleChange} required />
          <input className="form-input" name="password" placeholder="Password" type="password" onChange={handleChange} required />
          <button className="register-button" type="submit">Register</button>
        </form>
        <p className="register-link">Already have an account? <Link to="/login">Login here</Link></p>
      </div>
    </div>
  );
}

export default Register;
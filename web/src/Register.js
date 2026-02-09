import { useState } from "react";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";

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
    <div style={{ padding: "50px" }}>
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        <input name="firstName" placeholder="First Name" onChange={handleChange} required /><br /><br />
        <input name="lastName" placeholder="Last Name" onChange={handleChange} required /><br /><br />
        <input name="username" placeholder="Username" onChange={handleChange} required /><br /><br />
        <input name="email" placeholder="Email" type="email" onChange={handleChange} required /><br /><br />
        <input name="password" placeholder="Password" type="password" onChange={handleChange} required /><br /><br />
        <button type="submit">Register</button>
      </form>
      <p>Already have an account? <Link to="/login">Login here</Link></p>
    </div>
  );
}

export default Register;
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './styles.css';
import About from './About';
import Skills from './Skills';
import Projects from './Projects1';
import Contact from './Contact';

function App() {
  const [projects, setProjects] = useState([]);

  useEffect(() => {
    axios.get('/api/projects') // using proxy
      .then(response => setProjects(response.data))
      .catch(error => console.error('Error fetching projects:', error));
  }, []);

  return (
    <div>
      <About />
      <Skills />
      <Projects projects={projects} />
      <Contact />
    </div>
  );
}

export default App;
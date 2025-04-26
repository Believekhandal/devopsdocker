import React from 'react';

function Skills() {
  const skills = ['JavaScript', 'React', 'Spring Boot', 'HTML', 'CSS', 'Git']; // Add your skills

  return (
    <section>
      <h2>Skills</h2>
      <ul>
        {skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </section>
  );
}

export default Skills;
import React from 'react';

function Projects1({ projects }) { // Receive projects as props
  return (
    <section>
      <h2>Projects</h2>
      {projects.map((project) => (
        <div key={project.id}>
          <h3>{project.name}</h3>
          <p>{project.description}</p>
          <img src={project.imageUrl} alt={project.name} style={{ maxWidth: '200px' }} />
        </div>
      ))}
    </section>
  );
}

export default Projects1;
package com.alura.ForumHub.domain.services;

import org.springframework.stereotype.Service;

import com.alura.ForumHub.domain.entities.Course;
import com.alura.ForumHub.domain.repositories.CourseRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

/**
 * CourseService
 */
@Service
public class CourseService {

  private final CourseRepository courseRepository;

  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public Course findOrFail(Course course) {
    return courseRepository
        .findById(course.getId())
        .orElseThrow(() -> new EntityNotFoundException(
            String.format("Course with id %d not found", course.getId())));
  }

  @Transactional
  public Course save(Course course) {
    return courseRepository.save(course);
  }

}
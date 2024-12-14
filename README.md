# Student Database Management System

## Overview

The Student Database Management System is a Java application designed to help educational institutions manage student information, course enrollments, and tuition tracking efficiently. This console-based application allows administrators to create student profiles, enroll students in courses, and manage their tuition balances.

## Features

- **Student Profile Creation**
  - Enter student first and last names
  - Select grade level (Freshman, Sophomore, Junior, Senior)
  - Automatically generate unique student ID

- **Course Enrollment**
  - Enroll students in multiple courses
  - Prevent duplicate course enrollments
  - Flexible course selection process

- **Tuition Management**
  - Track tuition balance
  - Make partial or full tuition payments
  - Real-time balance updates

- **Robust Input Validation**
  - Comprehensive error handling
  - User-friendly input guidance
  - Prevents invalid data entry

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- An Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or NetBeans (recommended)

## Installation

1. Clone the repository:
```bash
git clone https://github.com/stephenombuya/studentdatabaseapp/tree/main
```

2. Navigate to the project directory:
```bash
cd student-database-app
```

3. Compile the Java files:
```bash
javac studentdatabaseapp/*.java
```

## Usage

Run the application:
```bash
java studentdatabaseapp.StudentDatabaseApp
```

### Workflow Example

1. Enter the number of students to register
2. For each student:
   - Input first name
   - Input last name
   - Select grade level
   - Enroll in courses
   - Make tuition payment

## Project Structure

```
student-database-app/
│
├── src/
│   └── studentdatabaseapp/
│       ├── Student.java        # Student class with core functionality
│       └── StudentDatabaseApp.java  # Main application entry point
│
├── README.md                   # Project documentation
└── LICENSE                     # Project license
```

## Example Interaction

```
Enter number of new students to enroll: 2

Enter details for Student 1:
Enter student first name: John
Enter student last name: Doe
Select student class level:
1 - Freshman
2 - Sophomore
3 - Junior
4 - Senior
Enter grade level: 2

Enter course to enroll (or 'Q' to quit): Mathematics
Enrolled in: Mathematics
Enter course to enroll (or 'Q' to quit): Computer Science
Enrolled in: Computer Science
Enter course to enroll (or 'Q' to quit): Q

Current balance: $1200
Enter your payment amount: $500
Thank you for your payment of $500
Current balance: $700
```

## Customization

- Modify `COST_OF_COURSE` constant to adjust course pricing
- Adjust grade level ranges in `MIN_GRADE_YEAR` and `MAX_GRADE_YEAR`

## Error Handling

The application includes comprehensive error handling:
- Invalid name inputs
- Out-of-range grade levels
- Negative or invalid payment amounts
- Duplicate course enrollments

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the  GNU GENERAL PUBLIC LICENSE. See `LICENSE` for more information.


## Acknowledgments

- Inspired by educational database management needs
- Built as a learning project in Java

---

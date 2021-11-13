package com.erp.school.service;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.school.entity.AcademicTimetable;
import com.erp.school.entity.AcademicYear;
import com.erp.school.entity.Board;
import com.erp.school.entity.Dayorder;
import com.erp.school.entity.Institution;
import com.erp.school.entity.MasterFaculty;
import com.erp.school.entity.MasterStudent;
import com.erp.school.entity.Program;
import com.erp.school.entity.Section;
import com.erp.school.entity.SerialNumbers;
import com.erp.school.entity.Standard;
import com.erp.school.entity.StudentStandardMapping;
import com.erp.school.entity.Subject;
import com.erp.school.entity.SubjectFacultyMapping;
import com.erp.school.entity.SubjectStandardMapping;
import com.erp.school.repository.SerialRepository;
import com.erp.school.repository.StudentRepository;
import com.etpl.common.exception.DAOPersistanceException;

@Transactional
@Service
public class MasterPersistService {

	@PersistenceContext
	private EntityManager emBean;
	
	@Autowired
	private SerialRepository serialRepo;
	
	@Autowired
	private StudentRepository studentRepo;

	public Institution newInstitution(Institution reqObj) {
		try {
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateInstitution(Institution reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public Board newBoard(Board reqObj) {
		try {
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateBoard(Board reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public Program newProgram(Program reqObj) {
		try {
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateProgram(Program reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public Standard newStandard(Standard reqObj) {
		try {
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateStandard(Standard reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public Subject newSubject(Subject reqObj) {
		try {
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateSubject(Subject reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public MasterFaculty newFaculty(MasterFaculty reqObj) {
		try {
			SerialNumbers resObj = serialRepo.findByRefInstId(reqObj.getRefInstId());
			if (resObj==null) {
				SerialNumbers refSerial = new SerialNumbers();
				refSerial.setRefInstId(reqObj.getRefInstId());
				refSerial.setStudentSerial(1);
				refSerial.setFacultySerial(1);
				emBean.persist(refSerial);
				
				int updatedSerial = 1;
				System.out.println("inside if updatedSerial : "+updatedSerial);
				String paddedSerialNumber = String.format("%05d", updatedSerial);
				String format = "T" + paddedSerialNumber;
				reqObj.getUserInfo().setUserLoginId(format);
				reqObj.getUserInfo().setPassword("PA"+paddedSerialNumber);
				emBean.persist(reqObj);
			} else {
				Integer facultySerial = resObj.getFacultySerial();
				Integer updatedSerial = facultySerial + 1;
				resObj.setFacultySerial(updatedSerial);
				emBean.merge(resObj);

				String paddedSerialNumber = String.format("%05d", updatedSerial);
				String format = "T" + paddedSerialNumber;
				reqObj.getUserInfo().setUserLoginId(format);
				reqObj.getUserInfo().setPassword("PA"+paddedSerialNumber);
				emBean.persist(reqObj);
			}
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateFaculty(MasterFaculty reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public MasterStudent newStudent(MasterStudent reqObj) {
		/*try {
			SerialNumbers resObj = Optional.ofNullable(serialRepo.findByRefInstId(reqObj.getRefInstId())).orElse(null);
			if (resObj==null) {
				SerialNumbers refSerial = new SerialNumbers();
				refSerial.setStudentSerial(0);
				refSerial.setFacultySerial(0);
				emBean.persist(refSerial);
			} else {
				int facultySerial = resObj.getFacultySerial();
				int updatedSerial = facultySerial + 1;
				emBean.merge(updatedSerial);

				String paddedSerialNumber = String.format("%05d", updatedSerial);
				String format = "ST" + paddedSerialNumber;
				reqObj.getUserInfo().setUserLoginId(format);
				reqObj.getUserInfo().setPassword("PA"+paddedSerialNumber);
				emBean.persist(reqObj);
			}
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}*/
		try {
			reqObj.setStatus("Applied");
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateStudent(MasterStudent reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}
	
	public StudentStandardMapping newStudentStandardMap(StudentStandardMapping reqObj) {
		try {
			SerialNumbers resObj = serialRepo.findByRefInstId(reqObj.getRefInstId());
			if (resObj==null) {
				SerialNumbers refSerial = new SerialNumbers();
				refSerial.setRefInstId(reqObj.getRefInstId());
				refSerial.setStudentSerial(1);
				refSerial.setFacultySerial(1);
				emBean.persist(refSerial);
				
				int updatedSerial = 1;
				System.out.println("inside if updatedSerial : "+updatedSerial);
				String paddedSerialNumber = String.format("%05d", updatedSerial);
				String format = "ST" + paddedSerialNumber;
				
				long studentId = reqObj.getRefStudentId();
				MasterStudent refStudent = studentRepo.findById(studentId);
				
				refStudent.getUserInfo().setUserLoginId(format);
				refStudent.getUserInfo().setPassword("PA"+paddedSerialNumber);
				emBean.merge(refStudent);
			} else {
				Integer facultySerial = resObj.getFacultySerial();
				Integer updatedSerial = facultySerial + 1;
				resObj.setFacultySerial(updatedSerial);
				emBean.merge(resObj);

				long studentId = reqObj.getRefStudentId();
				MasterStudent refStudent = studentRepo.findById(studentId);
				
				String paddedSerialNumber = String.format("%05d", updatedSerial);
				String format = "ST" + paddedSerialNumber;
				refStudent.getUserInfo().setUserLoginId(format);
				refStudent.getUserInfo().setPassword("PA"+paddedSerialNumber);
				emBean.merge(refStudent);
			}
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}
	
	public void updateStudentStandardMap(StudentStandardMapping reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public SubjectFacultyMapping newSubjectFacultyMap(SubjectFacultyMapping reqObj) {
		try {
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateSubjectFacultyMap(SubjectFacultyMapping reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public Section newSection(Section reqObj) {
		try {
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateSection(Section reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public AcademicYear newYear(AcademicYear reqObj) {
		try {
			Date fromDate = reqObj.getFromDate();
			Date toDate = reqObj.getToDate();
			
			int fromYear = getYear(fromDate);
			int toYear = getYear(toDate);
			String year = Integer.toString(fromYear) + "-" + Integer.toString(toYear);
			reqObj.setAcademicYear(year);
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	private int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	public void updateYear(AcademicYear reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public Dayorder newDayorder(Dayorder reqObj) {
		try {
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateDayorder(Dayorder reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public AcademicTimetable newTimetable(AcademicTimetable reqObj) {
		try {
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateTimetable(AcademicTimetable reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public SubjectStandardMapping newSubjectStandardMap(SubjectStandardMapping reqObj) {
		try {
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateSubjectStandardMap(SubjectStandardMapping reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	
}

package com.erp.school.service;

import java.util.List;
import java.util.Optional;

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
import com.erp.school.entity.Standard;
import com.erp.school.entity.Subject;
import com.erp.school.entity.SubjectFacultyMapping;
import com.erp.school.entity.SubjectStandardMapping;
import com.erp.school.repository.AcademicYearRepository;
import com.erp.school.repository.BoardRepository;
import com.erp.school.repository.DayorderRepository;
import com.erp.school.repository.FacultyRepository;
import com.erp.school.repository.InstitutionRepository;
import com.erp.school.repository.ProgramRepository;
import com.erp.school.repository.SectionRepository;
import com.erp.school.repository.StandardRepository;
import com.erp.school.repository.StudentRepository;
import com.erp.school.repository.SubjectFacultyRepository;
import com.erp.school.repository.SubjectRepository;
import com.erp.school.repository.SubjectStandardRepository;
import com.erp.school.repository.TimetableRepository;
import com.etpl.common.exception.RecordNotFoundException;

@Transactional
@Service
public class MasterViewService {
	@Autowired
	private InstitutionRepository instRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private ProgramRepository programRepo;
	
	@Autowired
	private StandardRepository standardRepo;
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Autowired
	private FacultyRepository facultyRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private SubjectFacultyRepository subjectFacultyRepo;
	
	@Autowired
	private SectionRepository sectionRepo;
	
	@Autowired
	private AcademicYearRepository yearRepo;
	
	@Autowired
	private DayorderRepository dayorderRepo;
	
	@Autowired
	private TimetableRepository timetableRepo;
	
	@Autowired
	private SubjectStandardRepository subStdRepo;

	public Institution getByInstitutionId(long institutionid) {
		return Optional.ofNullable(instRepo.findById(institutionid)).orElseThrow(
				() -> new RecordNotFoundException("No Institution Details Available in the System for the given ID"));
	}

	public List<?> getAllInstitutions() {
		return  (List<?>) Optional.ofNullable(instRepo.findAll())
				.orElseThrow(() -> new RecordNotFoundException("No Institutions found"));
	}

	public Board getByBoardId(long id) {
		return Optional.ofNullable(boardRepo.findById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}
	
	public List<Board> getBoardByInstId(long refInstId) {
		return Optional.ofNullable(boardRepo.findByRefInstId(refInstId)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public List<?> getAllBoards() {
		return  (List<?>) Optional.ofNullable(boardRepo.findAll())
				.orElseThrow(() -> new RecordNotFoundException("No Boards found"));
	}

	public Program getByProgramId(long id) {
		return Optional.ofNullable(programRepo.findById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public List<Program> getByInstIdAndBoardId(long refInstId, long refBoardId) {
		 return Optional.ofNullable(programRepo.findByRefInstIdAndRefBoardId(refInstId, refBoardId)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public Standard getStandardById(long id) {
		return Optional.ofNullable(standardRepo.findById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public List<Standard> getByInstIdAndProgramId(long refInstId, long refProgramId) {
		return Optional.ofNullable(standardRepo.findByRefInstIdAndRefProgramId(refInstId, refProgramId)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public Subject getSubjectById(long id) {
		return Optional.ofNullable(subjectRepo.findById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public List<Subject> getByInstIdAndCourseId(long refInstId, long refCourseId) {
		return Optional.ofNullable(subjectRepo.findByRefInstIdAndRefCourseId(refInstId, refCourseId)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public MasterFaculty getFacultyById(long id) {
		return Optional.ofNullable(facultyRepo.findById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public List<MasterFaculty> getFacultyByInstId(long refInstId) {
		return Optional.ofNullable(facultyRepo.findByRefInstId(refInstId)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public MasterStudent getStudentById(long id) {
		return Optional.ofNullable(studentRepo.findById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public List<MasterStudent> getByInstId(long refInstId) {
		return Optional.ofNullable(studentRepo.findByRefInstId(refInstId)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public SubjectFacultyMapping getSubjectFacultyMapById(long id) {
		SubjectFacultyMapping resObj = Optional.ofNullable(subjectFacultyRepo.findById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
		
		MasterFaculty refFaculty = facultyRepo.findById(resObj.getRefFacultyId());
		String facultyName = refFaculty.getUserInfo().getFirstName()+" "+refFaculty.getUserInfo().getLastName();
		resObj.setFacultyName(facultyName);
		
		Subject refSubject = subjectRepo.findById(resObj.getRefSubjectId());
		resObj.setSubjectName(refSubject.getSubjectName());
	
		return resObj;
	}

	public List<SubjectFacultyMapping> getByInstIdAndSubjectId(long refInstId, long refSubjectId) {
		List<SubjectFacultyMapping> resList = Optional.ofNullable(subjectFacultyRepo.findByRefInstIdAndRefSubjectId(refInstId, refSubjectId)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
		for (SubjectFacultyMapping subjectFacultyObj : resList) {
			MasterFaculty refFaculty = facultyRepo.findById(subjectFacultyObj.getRefFacultyId());
			String facultyName = refFaculty.getUserInfo().getFirstName()+" "+refFaculty.getUserInfo().getLastName();
			subjectFacultyObj.setFacultyName(facultyName);
			
			Subject refSubject = subjectRepo.findById(subjectFacultyObj.getRefSubjectId());
			subjectFacultyObj.setSubjectName(refSubject.getSubjectName());
		}
		return resList;
	}

	public List<SubjectFacultyMapping> getByInstIdAndFacultyId(long refInstId, long refFacultyId) {
		List<SubjectFacultyMapping> resList = Optional.ofNullable(subjectFacultyRepo.findByRefInstIdAndRefFacultyId(refInstId, refFacultyId)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
		for (SubjectFacultyMapping subjectFacultyObj : resList) {
			MasterFaculty refFaculty = facultyRepo.findById(subjectFacultyObj.getRefFacultyId());
			String facultyName = refFaculty.getUserInfo().getFirstName()+" "+refFaculty.getUserInfo().getLastName();
			subjectFacultyObj.setFacultyName(facultyName);
			
			Subject refSubject = subjectRepo.findById(subjectFacultyObj.getRefSubjectId());
			subjectFacultyObj.setSubjectName(refSubject.getSubjectName());
		}
		return resList;
	}

	public Section getSectionById(long id) {
		return Optional.ofNullable(sectionRepo.findById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public List<Section> getSectionByInstIdAndCourseId(long refInstId, long refCourseId) {
		return Optional.ofNullable(sectionRepo.findByRefInstIdAndRefCourseId(refInstId, refCourseId)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public AcademicYear getYearById(long id) {
		return Optional.ofNullable(yearRepo.findById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public List<AcademicYear> getYearByInstId(long refInstId) {
		return Optional.ofNullable(yearRepo.findByRefInstId(refInstId)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public Dayorder getDayorderById(long id) {
		return Optional.ofNullable(dayorderRepo.findById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public List<Dayorder> getDayorderByMultipleIds(Dayorder reqObj) {
		long instId = reqObj.getRefInstId();
		long boardId = reqObj.getRefBoardId();
		long programId = reqObj.getRefProgramId();
		long yearId = reqObj.getRefYearId();
		return Optional.ofNullable(dayorderRepo.findByRefInstIdAndRefBoardIdAndRefProgramIdAndRefYearId(instId, boardId, programId, yearId)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public AcademicTimetable getTimetableById(long id) {
		return Optional.ofNullable(timetableRepo.findById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public List<AcademicTimetable> getTimetableByMultipleIds(AcademicTimetable reqObj) {
		long instId = reqObj.getRefInstId();
		long boardId = reqObj.getRefBoardId();
		long programId = reqObj.getRefProgramId();
		long yearId = reqObj.getRefYearId();
		long sectionId = reqObj.getRefSectionId();
		return Optional.ofNullable(timetableRepo.findByRefInstIdAndRefBoardIdAndRefProgramIdAndRefYearIdAndRefSectionId(instId, boardId, programId, yearId, sectionId)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

	public SubjectStandardMapping getMapById(long id) {
		return Optional.ofNullable(subStdRepo.findById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}
	
	public List<SubjectStandardMapping> getSubjectStandardByInstIdAndSectionId(SubjectStandardMapping reqObj) {
		return Optional.ofNullable(subStdRepo.findByRefInstIdAndRefSectionId(reqObj.getRefInstId(), reqObj.getRefSectionId())).orElseThrow(
				() -> new RecordNotFoundException("No Details Available in the System for the given ID"));
	}

}
 
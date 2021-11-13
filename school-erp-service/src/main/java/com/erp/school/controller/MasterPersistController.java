package com.erp.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.erp.school.entity.StudentStandardMapping;
import com.erp.school.entity.Subject;
import com.erp.school.entity.SubjectFacultyMapping;
import com.erp.school.entity.SubjectStandardMapping;
import com.erp.school.service.MasterPersistService;
import com.etpl.common.util.ResponseObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Vivek
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/p/master/")
@Api(value = "School ERP Master Pesistance API", description = "School Persistance API can be used to create or update New Instituion/ Board/ Standard/ Section/ Subject/ Faculty entity", tags = {
		"School ERP Master Persistance API" })
public class MasterPersistController {
	
	@Autowired
	private MasterPersistService masterService;
	
	/** ########################### Institution Information ######################################## */

	@ApiOperation(value = "Create a New Institution" ,response = ResponseObject.class)
	@PostMapping(value = "new/institution/")
	public ResponseEntity<Institution> newInstitution(@RequestBody Institution reqObj) {
		Institution resObj = masterService.newInstitution(reqObj);
		return new ResponseEntity<Institution>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Institution information",response = ResponseObject.class)
	@PostMapping(value = "update/institution/")
	public ResponseEntity<?> updateInstitution(@RequestBody Institution reqObj) {
		masterService.updateInstitution(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Institution Details Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### BOARD Information ######################################## */

	@ApiOperation(value = "Create a New Board" ,response = ResponseObject.class)
	@PostMapping(value = "new/board/")
	public ResponseEntity<Board> newInstitution(@RequestBody Board reqObj) {
		Board resObj = masterService.newBoard(reqObj);
		return new ResponseEntity<Board>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Board information",response = ResponseObject.class)
	@PostMapping(value = "update/board/")
	public ResponseEntity<?> updateBoard(@RequestBody Board reqObj) {
		masterService.updateBoard(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Board Details Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Program Information ######################################## */

	@ApiOperation(value = "Create a New Program" ,response = ResponseObject.class)
	@PostMapping(value = "new/program/")
	public ResponseEntity<Program> newProgram(@RequestBody Program reqObj) {
		Program resObj = masterService.newProgram(reqObj);
		return new ResponseEntity<Program>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Program information",response = ResponseObject.class)
	@PostMapping(value = "update/program/")
	public ResponseEntity<?> updateProgram(@RequestBody Program reqObj) {
		masterService.updateProgram(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Program Details Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Standard Information ######################################## */

	@ApiOperation(value = "Create a New Standard" ,response = ResponseObject.class)
	@PostMapping(value = "new/standard/")
	public ResponseEntity<Standard> newStandard(@RequestBody Standard reqObj) {
		Standard resObj = masterService.newStandard(reqObj);
		return new ResponseEntity<Standard>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Standard information",response = ResponseObject.class)
	@PostMapping(value = "update/standard/")
	public ResponseEntity<?> updateStandard(@RequestBody Standard reqObj) {
		masterService.updateStandard(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Standard Details Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Subject Information ######################################## */

	@ApiOperation(value = "Create a New Subject" ,response = ResponseObject.class)
	@PostMapping(value = "new/subject/")
	public ResponseEntity<Subject> newSubject(@RequestBody Subject reqObj) {
		Subject resObj = masterService.newSubject(reqObj);
		return new ResponseEntity<Subject>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Subject information",response = ResponseObject.class)
	@PostMapping(value = "update/subject/")
	public ResponseEntity<?> updateSubject(@RequestBody Subject reqObj) {
		masterService.updateSubject(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Subject Details Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Faculty Information ######################################## */

	@ApiOperation(value = "Create Faculty Information" ,response = ResponseObject.class)
	@PostMapping(value = "new/faculty/")
	public ResponseEntity<ResponseObject> newFaculty(@RequestBody MasterFaculty reqObj) {
		masterService.newFaculty(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Faculty Details Created Successfully"), HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Faculty information",response = ResponseObject.class)
	@PostMapping(value = "update/faculty/")
	public ResponseEntity<?> updateFaculty(@RequestBody MasterFaculty reqObj) {
		masterService.updateFaculty(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Faculty Details Updated Successfully"),
				HttpStatus.OK);
	}

	/** ########################### Student Information ######################################## */

	@ApiOperation(value = "Create Student Information" ,response = ResponseObject.class)
	@PostMapping(value = "new/student/")
	public ResponseEntity<MasterStudent> newStudent(@RequestBody MasterStudent reqObj) {
		MasterStudent resObj = masterService.newStudent(reqObj);
		return new ResponseEntity<MasterStudent>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Student information",response = ResponseObject.class)
	@PostMapping(value = "update/student/")
	public ResponseEntity<?> updateStudent(@RequestBody MasterStudent reqObj) {
		masterService.updateStudent(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Student Details Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Student Standard Information ######################################## */

	@ApiOperation(value = "Mapping Student To Standard" ,response = ResponseObject.class)
	@PostMapping(value = "new/studentstandardmap/")
	public ResponseEntity<StudentStandardMapping> newStudentStandardMap(@RequestBody StudentStandardMapping reqObj) {
		StudentStandardMapping resObj = masterService.newStudentStandardMap(reqObj);
		return new ResponseEntity<StudentStandardMapping>(resObj, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Mapping Student To Standard" ,response = ResponseObject.class)
	@PostMapping(value = "update/studentstandardmap/")
	public ResponseEntity<?> updateStudentStandardMap(@RequestBody StudentStandardMapping reqObj) {
		masterService.updateStudentStandardMap(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Student Details Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Subject - Faculty Information ######################################## */

	@ApiOperation(value = "Create Subject Faculty Mapping" ,response = ResponseObject.class)
	@PostMapping(value = "new/subjectfacultymap/")
	public ResponseEntity<SubjectFacultyMapping> newSubjectFacultyMap(@RequestBody SubjectFacultyMapping reqObj) {
		SubjectFacultyMapping resObj = masterService.newSubjectFacultyMap(reqObj);
		return new ResponseEntity<SubjectFacultyMapping>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Subject Faculty Mapping",response = ResponseObject.class)
	@PostMapping(value = "update/subjectfacultymap/")
	public ResponseEntity<?> updateSubjectFacultyMap(@RequestBody SubjectFacultyMapping reqObj) {
		masterService.updateSubjectFacultyMap(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Subject Faculty Mapping Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Section Information ######################################## */

	@ApiOperation(value = "Create New Section" ,response = ResponseObject.class)
	@PostMapping(value = "new/section/")
	public ResponseEntity<Section> newSection(@RequestBody Section reqObj) {
		Section resObj = masterService.newSection(reqObj);
		return new ResponseEntity<Section>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Section",response = ResponseObject.class)
	@PostMapping(value = "update/section/")
	public ResponseEntity<?> updateSection(@RequestBody Section reqObj) {
		masterService.updateSection(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Section Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Academic Year Information ######################################## */

	@ApiOperation(value = "Create New Academic Year" ,response = ResponseObject.class)
	@PostMapping(value = "new/year/")
	public ResponseEntity<AcademicYear> newYear(@RequestBody AcademicYear reqObj) {
		AcademicYear resObj = masterService.newYear(reqObj);
		return new ResponseEntity<AcademicYear>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Academic Year",response = ResponseObject.class)
	@PostMapping(value = "update/year/")
	public ResponseEntity<?> updateYear(@RequestBody AcademicYear reqObj) {
		masterService.updateYear(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Academic Year Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Academic Day Order Information ######################################## */

	@ApiOperation(value = "Create New Academic Day Order" ,response = ResponseObject.class)
	@PostMapping(value = "new/dayorder/")
	public ResponseEntity<Dayorder> newDayorder(@RequestBody Dayorder reqObj) {
		Dayorder resObj = masterService.newDayorder(reqObj);
		return new ResponseEntity<Dayorder>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Day Order",response = ResponseObject.class)
	@PostMapping(value = "update/dayorder/")
	public ResponseEntity<?> updateDayorder(@RequestBody Dayorder reqObj) {
		masterService.updateDayorder(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Academic Dayorder Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Academic Timetable Information ######################################## */

	@ApiOperation(value = "Create New Academic Timetable" ,response = ResponseObject.class)
	@PostMapping(value = "new/timetable/")
	public ResponseEntity<AcademicTimetable> newTimetable(@RequestBody AcademicTimetable reqObj) {
		AcademicTimetable resObj = masterService.newTimetable(reqObj);
		return new ResponseEntity<AcademicTimetable>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Timetable",response = ResponseObject.class)
	@PostMapping(value = "update/timetable/")
	public ResponseEntity<?> updateTimetable(@RequestBody AcademicTimetable reqObj) {
		masterService.updateTimetable(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Academic Timetable Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Standard-Section-Subject Mapping ######################################## */

	@ApiOperation(value = "Create New Standard Subject Mapping" ,response = ResponseObject.class)
	@PostMapping(value = "new/subjectstandardmap/")
	public ResponseEntity<SubjectStandardMapping> newSubjectStandardMap(@RequestBody SubjectStandardMapping reqObj) {
		SubjectStandardMapping resObj = masterService.newSubjectStandardMap(reqObj);
		return new ResponseEntity<SubjectStandardMapping>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Standard Subject Mapping",response = ResponseObject.class)
	@PostMapping(value = "update/subjectstandardmap/")
	public ResponseEntity<?> updateSubjectStandardMap(@RequestBody SubjectStandardMapping reqObj) {
		masterService.updateSubjectStandardMap(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Standard Subject Mapping Updated Successfully"),
				HttpStatus.OK);
	}


}

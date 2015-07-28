-- region Department
INSERT INTO [Department] ( [id], [name] ) VALUES ( 0, 'Science' );
INSERT INTO [Department] ( [id], [name] ) VALUES ( 1, 'Math' );
INSERT INTO [Department] ( [id], [name] ) VALUES ( 2, 'Art' );
-- endregion 

-- region Teachers
INSERT INTO [Teachers] ( [id], [name] ) VALUES ( 0, 'Mr Smith' );
INSERT INTO [Teachers] ( [id], [name] ) VALUES ( 1, 'Mrs Jones' );
INSERT INTO [Teachers] ( [id], [name] ) VALUES ( 2, 'Mr Patel' );
INSERT INTO [Teachers] ( [id], [name] ) VALUES ( 3, 'Mr Harris' );
INSERT INTO [Teachers] ( [id], [name] ) VALUES ( 4, 'Ms Wong' );
-- endregion 

-- region Course
INSERT INTO Course ( id, name, descr, deptid, teacherid, upperlimit ) VALUES ( '0', 'Chemistry 101', 'First year Chemistry', '0', '2', '70' );
INSERT INTO Course ( id, name, descr, deptid, teacherid, upperlimit ) VALUES ( '1', 'Algebra 101', 'First year Algebra', '1', '0', '65' );
INSERT INTO Course ( id, name, descr, deptid, teacherid, upperlimit ) VALUES ( '2', 'Biology 102', 'First year Biology', '0', '1', '70' );
INSERT INTO Course ( id, name, descr, deptid, teacherid, upperlimit ) VALUES ( '3', 'Calculus 101', 'First year Calculus', '1', '0', '65' );
INSERT INTO Course ( id, name, descr, deptid, teacherid, upperlimit ) VALUES ( '4', 'Biology 202', 'Second year Biology', '0', '1', '40' );
INSERT INTO Course ( id, name, descr, deptid, teacherid, upperlimit ) VALUES ( '5', 'Music 101', 'Entry level instrumental music', '2', '3', '30' );
INSERT INTO Course ( id, name, descr, deptid, teacherid, upperlimit ) VALUES ( '6', 'Music 102', 'Entry level vocal', '2', '4', '15' );
INSERT INTO Course ( id, name, descr, deptid, teacherid, upperlimit ) VALUES ( '7', 'Art 101', 'Entry level visual arts course', '2', '4', '40' );
-- endregion 

CREATE TABLE 
    [OrgChartDBCompLeft].[Department] (
        [PrimaryKey] TEXT (255) NOT NULL PRIMARY KEY , 
        [ForeignKey] TEXT (255) NULL, 
        [Name] TEXT (255) NULL) ; 

INSERT INTO [OrgChartDBCompLeft].[Department] ([PrimaryKey],
                   [ForeignKey],
                   [Name])
VALUES ('1',
        '1',
        'Administration') ; 

INSERT INTO [OrgChartDBCompLeft].[Department] ([PrimaryKey],
                   [ForeignKey],
                   [Name])
VALUES ('2',
        '1',
        'Marketing') ; 


INSERT INTO [OrgChartDBCompLeft].[Department] ([PrimaryKey],
                   [ForeignKey],
                   [Name])
VALUES ('4',
        '1',
        'IT & Technical Support') ; 

--/////////

CREATE TABLE 
    [OrgChartDBCompRight].[Department] (
        [PrimaryKey] TEXT (255) NOT NULL PRIMARY KEY , 
        [ForeignKey] TEXT (255) NULL, 
        [Name] TEXT (255) NULL,
		[Type] TEXT (255) NULL) ; 

INSERT INTO [OrgChartDBCompRight].[Department] ([PrimaryKey],
                   [ForeignKey],
                   [Name],
					[Type])
VALUES ('1',
        '1',
        'Administration',
		'0') ; 

INSERT INTO [OrgChartDBCompRight].[Department] ([PrimaryKey],
                   [ForeignKey],
                   [Name],
					[Type])
VALUES ('3',
        '1',
        'Engineering',
		'1') ; 

INSERT INTO [OrgChartDBCompRight].[Department] ([PrimaryKey],
                   [ForeignKey],
                   [Name],
					[Type])
VALUES ('4',
        '1',
        'IT & Technical Support',
		'1') ; 

INSERT INTO [OrgChartDBCompRight].[Department] ([PrimaryKey],
                   [ForeignKey],
                   [Name],
					[Type])
VALUES ('7',
        '2',
        'Research & Development',
		null) ; 
SELECT [PrimaryKey], [ForeignKey], [Name], [Location], [Phone], [Fax], [EMail] FROM [Office] WHERE [Location] = "EU" OR [Location] <> "EU"  order by [PrimaryKey] DESC;

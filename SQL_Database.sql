DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Statuses;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Moderators;
DROP TABLE IF EXISTS Advertisements;



CREATE TABLE IF NOT EXISTS Categories
 (Category_ID varchar(3) NOT NULL,
  CatName varchar(20) NOT NULL,
  constraint pk_Category_ID primary key (Category_ID)
 );

CREATE TABLE IF NOT EXISTS Statuses
 (Status_ID varchar(3) NOT NULL,
  Status_Name varchar(20) NOT NULL,
  constraint pk_Status_ID primary key (Status_ID)
 );


CREATE TABLE IF NOT EXISTS Users
 (User_ID varchar(20) NOT NULL,
  UsrFirst_Name varchar(20) NOT NULL,
  UsrLast_Name varchar(20) NOT NULL,
  CONSTRAINT unique_person UNIQUE (UsrFirst_Name, UsrLast_Name),
  constraint pk_User_ID primary key (User_ID)
 );

CREATE TABLE IF NOT EXISTS Moderators
 (Moderator_ID varchar(20) NOT NULL,
  ModeFirst_Name varchar(20) NOT NULL,
  ModeLast_Name varchar(20) NOT NULL,
  CONSTRAINT unique_Moderator UNIQUE (ModeFirst_Name, ModeLast_Name),
  constraint pk_Moderator_ID primary key (Moderator_ID)
 
 );
  

CREATE TABLE IF NOT EXISTS Advertisements(
Advertisement_ID smallint unsigned NOT NULL auto_increment,
AdvTitle varchar(20) NOT NULL,
AdvDetails varchar(200) NOT NULL,
AdvDateTime datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
Price varchar(10)NOT NULL,

User_ID varchar(20),
Moderator_ID varchar(20),
Category_ID varchar(3),
Status_ID varchar(3) default 'PN',

constraint fk_Advertisements_Users foreign key (User_ID)
 references Users(User_ID) ON DELETE CASCADE,

constraint fk_Advertisements_Moderators foreign key (Moderator_ID)
 references Moderators(Moderator_ID) ON DELETE SET NULL,

constraint fk_Advertisements_Categories foreign key (Category_ID)
 references Categories(Category_ID) ON DELETE RESTRICT,

constraint fk_Advertisements_Statuses foreign key (Status_ID)
 references Statuses(Status_ID) ON DELETE RESTRICT,

constraint pk_Advertisement primary key (Advertisement_ID)
);

/* end table creation */

/* begin data population */
/*
/* Categories data */
insert into Categories (Category_ID,CatName)
values ('CAT','Carsa and Trucks'),('HOU','Housing'),('ELC','Electronics'),('CCA','Child Care');

/*  Statuses data  */
insert into Statuses (Status_ID,Status_Name)
values ('PN','Pending'),('AC','Active'),('DI','Disapproved');



/* Users data */
insert into Users (User_ID,UsrFirst_Name,UsrLast_Name)
values ('MSmith','Michael','Smith'),('SBarker','Susan','Barker'),('RTyler','Robert','Tyler'),
('SHawthorne','Susan','Hawthorne'),('JGooding','John','Gooding'),('HFleming','Helen','Fleming'),
('CTucker','Chris','Tucker'),('SParker','Sarah','Parker'),('JGrossman','Jane','Grossman'),
('PRoberts','Paula','Roberts'),('TZiegler','Thomas','Ziegler'),('SJameson','Samantha','Jameson'),
('JBlake','John','Blake'),('CMason','Cindy','Mason'),('FPortman','Frank','Portman'),
('TMarkham','Theresa','Markham'),('BFowler','Beth','Fowler'),('RTulman','Rick','Tulman');


/* Moderators data */

insert into Moderators (Moderator_ID,ModeFirst_Name,ModeLast_Name)
values ('AAlghamdi','Ayman','Alghamdi'),('MKuhail','Mohammad','Kuhail'),('AJavaid','Arslan ','Javaid');


/* Advertisements data */

insert into Advertisements (AdvTitle, AdvDetails, 
  Price, User_ID, Category_ID)
values ('2017 4X4', '2017 4X4 Jep car in great shape and clear title for sale', '35000', 
  (select User_ID from Users where UsrFirst_Name = 'Michael' AND UsrLast_Name = 'Smith'),  
'CAT'),('Single home', 'Single home ready to move. Built in 2008', '60000', 
  (select User_ID from Users where UsrFirst_Name = 'Thomas' AND UsrLast_Name = 'Ziegler'),  
'HOU'), ('2017 4X4', '2017 4X4 Jep car in great shape and clear title for sale', '35000', 
  (select User_ID from Users where UsrFirst_Name = 'Michael' AND UsrLast_Name = 'Smith'),  
'CAT'), ('2012 Sedan Ford', '2012 Sedan car in great shape and clear title for sale', '5500', 
  (select User_ID from Users where UsrFirst_Name = 'Susan' AND UsrLast_Name = 'Barker'),  
'CAT'), ('Samsung S8', 'Samsung S8 black color as new.', '2800', 
  (select User_ID from Users where UsrFirst_Name = 'Susan' AND UsrLast_Name = 'Barker'),  
'ELC');   
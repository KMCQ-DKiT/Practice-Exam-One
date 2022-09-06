drop database if exists football;
create database football;
CREATE TABLE results(
homeTeam varchar(30),
awayTeam varchar(30),
homeTeamGoals INT, 
awayTeamGoals INT    
 );
insert into results values("ManUtd","Liverpool",2,5);
insert into results values("Tottenham","ManCity",5,2);
insert into results values("Stoke","Wolves",2,0);
insert into results values("Chelsea","WestHam",1,1);

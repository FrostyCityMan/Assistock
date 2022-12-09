create table "Class(Item)"
(
    "Code(Class_item)" VARCHAR2(255) not null
        constraint PKCLASSITEM
            primary key,
    "Class(Item)"      VARCHAR2(255)
)
/

--

create table "Continent"
(
    "Code(Continent)" VARCHAR2(255) not null
        constraint PKCONTINENT
            primary key,
    "Continent"       VARCHAR2(255)
)
/

create table "Crawling(Weekly)"
(
    "Startdate"      DATE not null
        constraint PKCRAWLINGWEEKLY
            primary key,
    "Enddate"        DATE,
    "Entire(Weekly)" CLOB
)
/

create table "Crwaling(Now)"
(
    "Name(News)"           VARCHAR2(255),
    "URL(Now)"             VARCHAR2(255) not null
        constraint PKCRWALINGNOW
            primary key,
    "Date(Now)"            VARCHAR2(255),
    "Head(Now)"            VARCHAR2(255),
    "Largest1(Now)"        VARCHAR2(255),
    "Largest2(Now)"        VARCHAR2(255),
    "Largest3(Now)"        VARCHAR2(255),
    "Largest4(Now)"        VARCHAR2(255),
    "Largest5(Now)"        VARCHAR2(255),
    "Entire(Now)"          CLOB,
    "Largest1(Now_number)" NUMBER,
    "Largest2(Now_number)" NUMBER,
    "Largest3(Now_number)" NUMBER,
    "Largest4(Now_number)" NUMBER,
    "Largest5(Now_number)" NUMBER,
    "Entire(Now_number)"   NUMBER,
    "Class(News)"          VARCHAR2(255)
)
/

create table "Detail(Item)"
(
    "Code(Detail_item)" VARCHAR2(255) not null
        constraint PKDETAIL
            primary key,
    "Detail(Item)"      VARCHAR2(255)
)
/

create table "Group(Material)"
(
    "Code(Group_Material)" VARCHAR2(255) not null
        constraint PKGROUPMATERIAL
            primary key,
    ISO                    VARCHAR2(255),
    "Continent"            VARCHAR2(255)
)
/

create table "Group(Stock)"
(
    "Code(Group_stock)" VARCHAR2(255) not null
        constraint PKGROUPSTOCK
            primary key,
    "Code(Stock)"       VARCHAR2(255),
    "Theme(Stock)"      VARCHAR2(255)
)
/

create table "Material"
(
    ISO                 VARCHAR2(255) not null
        constraint PKMATERIAL
            primary key,
    "Name(Country)"     VARCHAR2(255),
    "Name(Country_eng)" VARCHAR2(255),
    "Continent"         VARCHAR2(255),
    "Class(Item)"       VARCHAR2(255),
    "Detail(Item)"      VARCHAR2(255),
    "Value(Material)"   BINARY_DOUBLE
)
/

create table "Member"
(
    "Name(Register)" VARCHAR2(255),
    "Email"          VARCHAR2(255) not null
        constraint PKMEMBER
            primary key,
    ID               VARCHAR2(255),
    PW               VARCHAR2(255),
    "Class(Member)"  VARCHAR2(255),
    "Date(Sub)"      DATE,
    "Name(Member)"   VARCHAR2(255),
    "Date(Join)"     DATE,
    "Tel"            VARCHAR2(255)
)
/
create table "Name(Country)"
(
    ISO             VARCHAR2(255) not null
        constraint PKCOUNTRYNAME
            primary key,
    "Name(Country)" VARCHAR2(255)
)
/
create table "News"
(
    "Code(News)" VARCHAR2(255) not null
        constraint PKNEWS
            primary key,
    "Name(News)" VARCHAR2(255)
)
/

create table "Register"
(
    "Code(Register)" BINARY_DOUBLE not null
        constraint PKREGISTER
            primary key,
    "Name(Register)" VARCHAR2(255)
)
/

create table "Sitemap"
(
    "Code(Sitemap)"  VARCHAR2(255) not null
        constraint PKSITEMAP
            primary key,
    "URL(stiemap)"   VARCHAR2(255),
    "Class(Sitemap)" VARCHAR2(255),
    "Board(Sitemap)" VARCHAR2(255)
)
/

create table "Stock"
(
    "Code(Stock)"  VARCHAR2(255) not null
        constraint PKSTOCK
            primary key,
    "Name(Stock)"  VARCHAR2(255),
    "Class(Item)"  VARCHAR2(255),
    "Class(Stock)" VARCHAR2(255)
)
/
create table "Stock_value"
(
    "Code(Stock)"       VARCHAR2(255) not null
        constraint PKSTVAL
            primary key,
    "Name(Stock)"       VARCHAR2(255),
    "Past"              DATE,
    "Value(Stock_Past)" BINARY_DOUBLE,
    "Now"               DATE,
    "Value(Stock_Now)"  BINARY_DOUBLE
)
/

create table "Theme(Stock)"
(
    "Code(Theme_Stock)" VARCHAR2(255) not null
        constraint PKTHEME
            primary key,
    "Theme(Stock)"      VARCHAR2(255)
)
/

create table "Word"
(
    "Code(Word)" VARCHAR2(20) not null
        constraint PKWORD
            primary key,
    "Word"       VARCHAR2(255),
    "Score"      BINARY_DOUBLE
)
/

create table "Word(Material)"
(
    "Name(News)"    VARCHAR2(255),
    "Name(Country)" VARCHAR2(255),
    "Class(Item)"   VARCHAR2(255),
    "URL(Now)"      VARCHAR2(255) not null
        constraint PKWORDMATERIAL
            primary key,
    "Date(Now)"     VARCHAR2(255),
    "Head(Now)"     VARCHAR2(255),
    "Entire(Now)"   CLOB,
    "Score"         BINARY_DOUBLE
)
/

create table "Word(Analysis)"
(
    "Name(News)"    VARCHAR2(255),
    "Name(Stock)"   VARCHAR2(255),
    "Class(Item)"   VARCHAR2(255),
    "URL(Now)"      VARCHAR2(255) not null
        constraint PKWORDSTOCK
            primary key,
    "Date(Now)"     VARCHAR2(255),
    "Head(Now)"     VARCHAR2(255),
    "Entire(Now)"   CLOB,
    "Score"         BINARY_DOUBLE,
    "Name(Country)" VARCHAR2(255)
)
/

create table "Word(dayAnalysis)"
(
    "Date"           VARCHAR2(255) not null,
    "Word(Analysis)" VARCHAR2(255) not null,
    "Word(Count)"    NUMBER,
    "Class(News)"    VARCHAR2(255) not null,
    constraint "Word(dayAnalysis)_pk"
        primary key ("Word(Analysis)", "Date", "Class(News)")
)
/











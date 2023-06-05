create schema ArborVitae;
use ArborVitae;

CREATE TABLE Tree
(
  CodeTree INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Name VARCHAR(32) NOT NULL,
    Species VARCHAR(128) NOT NULL,
    Country VARCHAR(128) NOT NULL,
    CO2 VARCHAR(16) NOT NULL,
    Description VARCHAR(512) NOT NULL,
    Price DOUBLE NOT NULL
);

CREATE TABLE User
(
    Email VARCHAR(128) PRIMARY KEY NOT NULL,
    Name VARCHAR(64) NOT NULL,
    Surname VARCHAR(64) NOT NULL,
    Country VARCHAR(64) NOT NULL,
    Role VARCHAR(16) NOT NULL,
    Password VARCHAR(128) NOT NULL
);

CREATE TABLE Certificate
(
  CodeCertificate INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Name VARCHAR(64) NOT NULL,
    Description VARCHAR(256) NOT NULL,
    Date DATE NOT NULL
);

CREATE TABLE ShoppingCart
(
  CodeCart INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Email VARCHAR(128) NOT NULL,
  NumItems INT DEFAULT 0,
  FOREIGN KEY (Email) REFERENCES User(Email) ON UPDATE cascade ON DELETE cascade
);

CREATE TABLE IsIn
(
  CodeCart INT NOT NULL,
    CodeTree INT NOT NULL,
    FOREIGN KEY (CodeCart) REFERENCES ShoppingCart(CodeCart) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY (CodeTree) REFERENCES Tree(CodeTree) ON UPDATE cascade ON DELETE cascade
);

CREATE TABLE Orders
(
  Email VARCHAR(128) NOT NULL,
    CodeOrder INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    Data DATE NOT NULL,
    FOREIGN KEY (Email) REFERENCES User(Email) ON UPDATE cascade ON DELETE cascade
);

CREATE TABLE Products
(
    CodeOrder INT NOT NULL,
    CodeProduct INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Name VARCHAR(32) NOT NULL,
    Species VARCHAR(128) NOT NULL,
    Country VARCHAR(128) NOT NULL,
    CO2 VARCHAR(16) NOT NULL,
    Description VARCHAR(512) NOT NULL,
    Price DOUBLE NOT NULL,
    Quantity INT DEFAULT(0),
    FOREIGN KEY (CodeOrder) REFERENCES Orders(CodeOrder) ON UPDATE cascade ON DELETE cascade
);

CREATE TABLE MadeBy
(
  CodeOrder INT NOT NULL,
    CodeProduct INT NULL,
    FOREIGN KEY (CodeProduct) REFERENCES Products(CodeProduct) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY (CodeOrder) REFERENCES Orders(CodeOrder) ON UPDATE cascade ON DELETE cascade
);

INSERT INTO Tree(Name, Species, Country, CO2, Description, Price)
Values
  ("Anacardo", "Anacardium Occidentale", "Ghana", "-300Kg", "Specie originaria del Brasile, è un albero sempreverde molto ramificato. Il frutto si compone di una parte una carnosa simile ad una mela - in realtà un falso frutto - e di una parte secca: l'anacardo che tutti noi conosciamo. L'anacardo viene piantato per aiutare l'economia delle piccole comunità rurali del Senegal e per proteggere gli appezzamenti dal fuoco.", 26.90),
  ("Avocado", "Persea Americana", "Tanzania", "-500Kg", "L'Avocado è principalmente conosciuto per i suoi frutti altamente energetici e ricchi di nutrienti. L'olio estratto dal frutto è usato nella cosmesi per le sue proprietà antiossidanti e rivitalizzanti, mentre le foglie hanno ottime proprietà cicatrizzanti. Viene piantato per la produzione di frutti e come albero da ombra per altre colture.", 29.90),
    ("Baobab", "Adansonia Digitata", "Madagascar", "-3000Kg", "Il Baobab è una specie originaria del Madagascar e diffusa in tutta l'Africa. Celebre per la sua imponenza, pensate che il diametro del tronco può arrivare a 10 metri. È considerato il centro gravitazionale della vita sociale dei villaggi, sotto la sua ombra si tengono mercati, riunioni, danze e giochi. Viene piantato per contribuire al recupero delle foreste naturali.", 78.54),
    ("Banano","Musa Paradisiaca","Camerun","-10kg","Il Banano è una pianta erbacea gigante della famiglia delle Musaceae, che può crescere fino a 6-7 m di altezza. Originario dell'Asia, viene coltivato principalmente nel Centro America, Africa Tropicale e Filippine. Fruttifica solo in climi tropicali e necessita di protezione dai venti. Viene piantato per l'uso alimentare e per la commercializzazione dei suoi frutti.",18.90),
  ("Caffè", "Coffea Arabica", "Kenya", "-55Kg", "Il Caffè, dai cui semi si ricava l’omonima bevanda, appartenente alla famiglia delle Rubiaceae. Sebbene ne esistano oltre 100 specie, come ci confermano gli scaffali dei supermercati, le più diffuse sono l'arabica e la robusta. Il caffé rappresenta un'importante fonte di reddito per le comunità locali.", 19.90),
  ("Cedro", "Cedrela Odorata", "Haiti", "-500Kg", "La Cedrela odorata è un'importante specie della famiglia delle Meliaceae, chiamato anche Cedro Spagnolo. Originario del Centro America, questo albero di medie dimensioni è utilizzato per la sua resina insetto-repellente e per la produzione di miele.", 26.90),
    ("Chicozapote", "Manilkara Zapota", "Guatemala", "-100Kg", "È un albero di dimensioni ragguardevoli, capace di crescere fino a superare i 30 metri di altezza. Ha una chioma molto densa e fitta, stratificata orizzontalmente. Sviluppa un apparato radicale molto esteso e capace di trattenere gran quantità di terreno. I suoi fiori sono bianchi e molto profumati ed i frutti sono bacche marroni rotonde, leggermente oblunghe, dalla polpa dolce e saporita.", 22.90),
    ("Fromager", "Celba Pentandra", "Ghana", "-2000Kg", "Il Fromager è un albero che raggiunge i 70 metri ed è dotato di un tronco massiccio che può arrivare a 3 metri di diametro èd è ricoperto di larghe e robuste spine. Viene piantato allo scopo di riforestare, alimentare il bestiame e di ombreggiare aree destinate alla coltivazione di piante a basso fusto.", 48.54),
    ("Grevillea", "Grevillea Robusta", "Tanzania", "-800Kg", "a Grevillea robusta raggiunge altezze di 12- 25 metri; i fiori sono di un giallo vistoso e ricchi di un nettare che attrae le api stimolandone l’integrazione con l’ecosistema e favorendo l’impollinazione delle piante. Viene utilizzata anche come pianta frangivento e consente la formazione naturale di humus mantenendo l’umidità e migliorando la qualità del suolo", 27.90),

("Macadamia", "Macadamia integrifolia", "Kenya", "-300Kg", "La Macadamia è un sempreverde della famiglia delle Proteaceae. Può raggiungere i 40 metri e presenta foglie ellittiche e fiori bianchi-rosacei a grappoli. Originaria dell'Australia la Macadamia è coltivata per i suoi semi, da cui si produce olio e per i suoi frutti, le famose noci di macadamia, molto nutrienti e ricche di minerali.", 29.30),
    ("Palissandro", "Dalbergia monticola", "Madagascar", "-200Kg", "È un albero che raggiunge e supera abbondantemente i 30 metri di altezza. Il diametro del tronco può raggiungere i 140 cm. I rami giovani sono pubescenti (significa che sono coperti da una leggera peluria) mentre i rami più vecchi sono senza foglie, questi possono arrivare fino a 20 metri di lunghezza con un diametro di 20 cm. È splendido quando fiorisce e la sua chioma si corona di grappoli di fiori.", 61.96)
;

INSERT INTO User(Email, Name, Surname, Country, Role, Password)
Values
  ("mariaadmin@hotmail.it", "Maria", "Colella", "it", "Admin", "bacb6c8f78b656fae7edddc9ccc3ac62222efc45")
;

INSERT INTO User(Email, Name, Surname, Country, Role, Password)
Values
 ("carloadmin@gmail.it", "Carlo", "Sorrentino", "it", "Admin", "bacb6c8f78b656fae7edddc9ccc3ac62222efc45")
;
1. Values - DONE
String bookTitle;
String authorName;
String authorSurname;
int ISBN; // International Standard Book Number
int numberOfPages;
int readersBookScore; // from 1 to 5; 0 - ja vēl nav lasījis grāmatu, ar iespēju mainīt pēc lasīšanas
int yearBookWasPublished;
String genre; (if vai switch) // vai arī būs atsevišķas klases, kuras extends Book. Un tad kādai klasei ielikt vecuma iebobežojumu, atkārībā no žanra.

2. Methods
DBConnection void addBook(); // ja šāda grāmata jau ir datu bāzē, tad sistēma pajautās, vai tiešām vēlies ievadīt šādu grāmatu: YES/ NO, un pēc YES nospiešanas saglabās.
??? checkIfBookIsInDatabase();
DBConnection void deleteBook();
addReadersRating(); // lasītājs izlasija – uzlika atzīmi
calculateRating();
recommendToReadAgainIfRatingMoreThanThree();
Book return findBookByName(); // +sout all information about book or sout “There is no book with this name.”
Book return findBookByGenre(); // +sout all information about all books or sout “There is no book with this genre.”
Book return findBookByAuthor();
Book return findBookByRating();
Book return findOldestBook();
void markIfBookIsRead(); // YES/NO
Book return calculateHowManyBooksAreRead();
Book return calculateHowManyBookOfOneGenreAreInLibrary(); // vai katram žanram ir nepieciešama sava metode? Man liekas, ka var rēķināt ar vienu.
Book return calculateHowManyBookOfOneGenreAreRead();

??? recommendAnotherBookAccordingToReadersBookRating(); // rekomendācijas, ko lasīt no tā paša žanra, balstoties uz to, kāda grāmata iepatikās.

3.	Menu - DONE
Choose what to do:
1 – add book;
2 – print information about all books;
3 – find book by … // vai šeit katram meklēšanas variantam ir nepieciešams savs ciprars vai arī var uzrakstīt meklēšanas kodu zem viena cipara?
4 – check how many books are read; 
5 – delete book;


4.	Ja būs laiks
- grāmatas atdošanas datums;
- info par vietu, kur grāmata jāatgriež; // personīgi + pilsēta vai sūtīt ar, piemēram, Omniva
- info par cilvēku, kurš paņēma grāmatu; // vārds, uzvārds, telefona numurs, reitings
Programma vai nu default visulaiku rādīs, cik grāmatas un līdz kuram datumam jāatdod, vai arī atdošanas informācija parādīsies, meklējot konkrēto grāmatu. Būs metode, kura automātiski saskaitīs, 
cik dienas ir palicis līdz nodošanai un rādīs brīdinājumu par mazāk par X dienām.
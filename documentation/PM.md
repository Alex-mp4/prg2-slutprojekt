# Slutprojekt | prg2 | Post Mortem

- titel: Förbättrade Kortspelet (Nu med Server-Client)
- tagline: Spelet där klasserna är obalanserade!
- git: https://github.com/Alex-mp4/prg2-slutprojekt

## Inledning
Syftet med detta projekt är att förbättra kortspelet (skapad tidigare i kursen) genom att implementera en Server och en Client som kan koppla till varandra. Med detta ska båda kunna välja varsitt kort över nätet och spela dem mot varandra. Det görs för att följa och uppfylla de kriterium skapade inför detta slutprojekt.

## Bakgrund
Egentligen är detta projekt en kombination av två tidigare projekt gjort under programmering2 kursen. Det vill säga; Chatprogrammet och Kortspelet. Chatprogrammet lägger grunden till att koppla två separata användare till samma program, där de kan kommunicera och skicka information mellan varandra. Kortspelet lägger istället grunden till exakt vad programmet ska göra och åstadkomma. Anledningen varför jag valde att göra detta ligger i att objektprogrammering och mer specifikt kortspelet var bland det roligaste vi har gjort inom programmering hittills.

Först och framförallt skapades en README-fil där det fanns en detaljerad beskrivning av vad projektet skulle göra. När denna beskrivning blev godkänd fortsatte jag genom att göra en planering över utseendet på Views:en (skapat i Figma) och vilka funktionaliteter som behövdes (främst från chatprogrammet). Därefter kunde det praktiska arbetet börja med uppdateringar i planerings dokumentet efter varje pass.

Jag började med att göra grundstrukturen av projektet genom att tillföra alla filer. Det vill säga, Client filerna (varav controller, listenerthread, model och view) och Server filerna (varav controller, listenerthread, model och view). Dessutom implementerade jag objekten från kortspelet ("klasserna"). Sedan förberedde jag en "executable"-fil som startar både servern och klienten.

Därefter gjorde jag designen för GUI så att alla byggdelar fanns tillgängliga. Med det gjort kunda jag påbörja kopplingen mellan server och klient så att båda kan ta del av varandras GUI. För spelets funktioner tog jag koden från kortspelet, med omformatering för att passa programmet.

## Negativa erfarenheter
Det mesta fungerade relativt bra förrän självaste kopplingen påbörjades. För att skicka klasserna mellan server och client använde jag ett liknande system till chatprogrammet där den läser av inskickade rader. På grund av dess upplägg måste man köra "Ready" på Client, sedan "Ready" på Server, och sist Client igen. Då känner båda igen vilka klasser som behövs.

Dessutom fick jag problem med att "brawl" inte kände igen de två olika controllers:erna. För att fixa detta behövda jag omformatera "card"-filen likt hur andra MVC funktioner kopplas samman.

## Positiva erfarenheter
Helt enkelt var det kul att utveckla kortspelet vidare så att det blir ett mer fungerande spel än vad det var tidigare.

## Sammanfattning
Allt som allt har jag skapat ett kortspel där en server och en klient kan välja varsitt kort och spela dem mot varandra för att utse en vinnare. För att göra detta har jag, i princip, sammankopplat två tidigare projekt och förändrat dem för att passa tillfället.
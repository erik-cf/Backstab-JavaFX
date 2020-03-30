package com.mpec.main;

public class Strings {
	
	/**
	 * Login
	 */
	public static String LOGINTITLE;
	public static String USERNAMELABEL;
	public static String USERNAMEFIELD;
	public static String PASSWORDLABEL;
	public static String PASSWORDFIELD;
	public static String LOGINBUTTON;
	

	/**
	 * Alertas
	 */
	public static String NONETWORKALERT;
	public static String NONETWORKTITLE;
	public static String NOTEMPTYCHOICEBOX;
	public static String NOTEMPTYTEXTFIELD;
	
	/**
	 * Men�s
	 */
	public static String APPLICATIONMENU;
	public static String DOCUMENTSMENU;
	public static String VIEWMENU;
	public static String LOGOUTMENUITEM;
	public static String EXITMENUITEM;
	public static String NEWMENUITEM;
	public static String SEARCHMENUITEM;
	public static String CONFIGURATIONMENUITEM;
	
	/**
	 * Contenido
	 */
	// Edit Button
	public static String EDITBUTTON;
	
	// Table characters
	public static String COLUMNCHARNAME;
	public static String COLUMNATTACK;
	public static String COLUMNDEFENSE;
	public static String COLUMNHP;
	public static String COLUMNMOVEMENTSPEED;
	public static String COLUMNATTACKSPEED;
	public static String COLUMNRANGE;
	
	// Table drops data
	public static String COLUMNDROPNAME;
	public static String COLUMNVALUE;
	public static String COLUMNDURATION;
	public static String COLUMNMINRANGE;
	public static String COLUMNMAXRANGE;
	
	// Map screen
	public static String PHASETIME;
	public static String MINDROPTIME;
	public static String MAXDROPTIME;
	public static String MONSTERSCOUNT;
	public static String COLLISIONPROB;
	public static String APPLYBUTTON;
	
	// GameStatistics
	public static String GAMENAME;
	public static String TOTALGAMES;
	public static String TOTALPLAYERS;
	public static String AVERAGETIME;
	public static String AVERAGEDMGDEALT;
	public static String AVERAGEDMGRECEIVED;
	public static String AVERAGEDROPSPICKED;
	public static String REFRESHBUTTON;
	
	// UserSearch
	public static String FIELDLABEL;
	public static String NAMECHOICE;
	public static String SURNAMECHOICE;
	public static String USERNAMECHOICE;
	public static String MAILCHOICE;
	public static String VALUELABEL;
	public static String SEARCHBUTTON;
	
	// NewUser
	public static String NAMELABEL;
	public static String SURNAMELABEL;
	public static String MAILLABEL;
	public static String ROLELABEL;
	public static String ADMINCHOICE;
	public static String NORMALCHOICE;
	public static String SENDBUTTON;
	
	/**
	 * Navigation bar
	 */
	public static String EDITSTATSNAV;
	public static String CHARACTERNAV;
	public static String ENEMYNAV;
	public static String MAPNAV;
	public static String DROPSDATANAV;
	public static String GAMEINFONAV;
	public static String GAMESTATISTICSNAV;
	public static String USERSNAV;
	public static String SEARCHUSERNAV;
	public static String NEWUSERNAV;
	
	static {
		
		if(Constants.language.equals("english")){
			
			LOGINTITLE = "Backstab Administration Panel - Login";
			USERNAMELABEL = "Username";
			USERNAMEFIELD = "Username...";
			PASSWORDLABEL = "Password";
			PASSWORDFIELD = "Password...";
			LOGINBUTTON = "LOGIN";
			
			NONETWORKALERT = "Your network is not available, you should check your network availability!";
			NONETWORKTITLE = "Network unavailable!";
			NOTEMPTYCHOICEBOX = "You must select one option from the list!";
			NOTEMPTYTEXTFIELD = "You must fill the text field!";
			
			APPLICATIONMENU = "Application";
			DOCUMENTSMENU = "Documents";
			VIEWMENU = "View";
			LOGOUTMENUITEM = "Logout";
			EXITMENUITEM = "Exit";
			SEARCHMENUITEM = "Search...";
			NEWMENUITEM = "New...";
			CONFIGURATIONMENUITEM = "Configuration";
			
			EDITBUTTON = "EDIT";
			
			COLUMNCHARNAME = "Char Name";
			COLUMNATTACK = "Attack";
			COLUMNDEFENSE = "Defense";
			COLUMNHP = "HP";
			COLUMNMOVEMENTSPEED = "Movement Speed";
			COLUMNATTACKSPEED = "Attack Speed";
			COLUMNRANGE = "Range";
			
			COLUMNDROPNAME = "Drop Name";
			COLUMNVALUE = "Value";
			COLUMNDURATION = "Duration (Seconds)";
			COLUMNMINRANGE = "Min Range";
			COLUMNMAXRANGE = "Max Range";
			
			PHASETIME = "Phase Time";
			MINDROPTIME = "Min Drop Time";
			MAXDROPTIME = "Max Drop Time";
			MONSTERSCOUNT = "Base Monsters Count";
			COLLISIONPROB = "Collision Objects Probability";
			APPLYBUTTON = "APPLY";
			
			GAMENAME = "Name:";
			TOTALGAMES = "Total games:";
			TOTALPLAYERS = "Total players:";
			AVERAGETIME = "Average game time:";
			AVERAGEDMGDEALT = "Average damage dealt:";
			AVERAGEDMGRECEIVED = "Average damage received:";
			AVERAGEDROPSPICKED = "Average drops picked:";
			REFRESHBUTTON = "Refresh";
			
			FIELDLABEL = "Select the Field";
			NAMECHOICE = "Name";
			SURNAMECHOICE = "Surname";
			USERNAMECHOICE = "Username";
			MAILCHOICE = "E-Mail";
			VALUELABEL = "Insert the Value";
			SEARCHBUTTON = "SEARCH";
			
			NAMELABEL = "Name";
			SURNAMELABEL = "Surname";
			MAILLABEL = "E-Mail";
			ROLELABEL = "Role";
			ADMINCHOICE = "Administrator";
			NORMALCHOICE = "Normal User";
			SENDBUTTON = "ENVIAR";
			
			EDITSTATSNAV = "EDIT STATS";
			CHARACTERNAV = "Character";
			ENEMYNAV = "Enemy";
			MAPNAV = "Map";
			DROPSDATANAV = "Drops Data";
			GAMEINFONAV = "GAME INFO";
			GAMESTATISTICSNAV = "Game Statistics";
			USERSNAV = "USERS";
			SEARCHUSERNAV = "Search User";
			NEWUSERNAV = "New User";
			
		}else if(Constants.language.equals("spanish")) {
			
			LOGINTITLE = "Administraci�n de Backstab - Iniciar sesi�n";
			USERNAMELABEL = "Nombre de usuario";
			USERNAMEFIELD = "Nombre de usuario...";
			PASSWORDLABEL = "Contrase�a";
			PASSWORDFIELD = "Contrase�a...";
			LOGINBUTTON = "Iniciar Sesi�n";
			
			NONETWORKALERT = "No hay conexi�n a Internet, deber�as revisar tu conexi�n!";
			NONETWORKTITLE = "Internet no disponible!";
			NOTEMPTYCHOICEBOX = "Debes seleccionar un elemento de la lista!";
			NOTEMPTYTEXTFIELD = "Debes rellenar el campo de texto!";
			
			APPLICATIONMENU = "Aplicaci�n";
			DOCUMENTSMENU = "Documentos";
			VIEWMENU = "Ver";
			LOGOUTMENUITEM = "Cerrar sesi�n";
			EXITMENUITEM = "Salir";
			SEARCHMENUITEM = "Buscar...";
			NEWMENUITEM = "Nuevo...";
			CONFIGURATIONMENUITEM = "Configuraci�n";
			
			EDITBUTTON = "EDITAR";
			
			COLUMNCHARNAME = "Nombre Caracter";
			COLUMNATTACK = "Ataque";
			COLUMNDEFENSE = "Defensa";
			COLUMNHP = "HP";
			COLUMNMOVEMENTSPEED = "Velocidad de Movimiento";
			COLUMNATTACKSPEED = "Velocidad de Ataque";
			COLUMNRANGE = "Rango";
			
			COLUMNDROPNAME = "Nombre del Drop";
			COLUMNVALUE = "Valor";
			COLUMNDURATION = "Duraci�n (Segundos)";
			COLUMNMINRANGE = "Rango M�nimo";
			COLUMNMAXRANGE = "Rango M�ximo";
			
			PHASETIME = "Tiempo de Fase";
			MINDROPTIME = "Tiempo M�nimo de Drop";
			MAXDROPTIME = "Tiempo M�ximo de Drop";
			MONSTERSCOUNT = "N�mero Base de Monstruos";
			COLLISIONPROB = "Probabilidad de Objetos de Colisi�n";
			APPLYBUTTON = "Aplicar";
			
			GAMENAME = "Nombre:";
			TOTALGAMES = "Juegos totales:";
			TOTALPLAYERS = "Jugadores totales:";
			AVERAGETIME = "Promedio de tiempo de juego:";
			AVERAGEDMGDEALT = "Promedio de da�o hecho:";
			AVERAGEDMGRECEIVED = "Promedio de da�o recibido:";
			AVERAGEDROPSPICKED = "Promedio de drops recogidos:";
			REFRESHBUTTON = "Actualizar";
			
			FIELDLABEL = "Selecciona el Campo";
			NAMECHOICE = "Nombre";
			SURNAMECHOICE = "Apellido";
			USERNAMECHOICE = "Nombre de usuario";
			MAILCHOICE = "Correo Electr�nico";
			VALUELABEL = "Inserta el Valor";
			SEARCHBUTTON = "BUSCAR";
			
			NAMELABEL = "Nombre";
			SURNAMELABEL = "Apellido";
			MAILLABEL = "Correo Electr�nico";
			ROLELABEL = "Rol";
			ADMINCHOICE = "Administrador";
			NORMALCHOICE = "Usuario Normal";
			SENDBUTTON = "ENVIAR";
			
			EDITSTATSNAV = "EDITAR";
			CHARACTERNAV = "Caracter";
			ENEMYNAV = "Enemigo";
			MAPNAV = "Mapa";
			DROPSDATANAV = "Datos Drops";
			GAMEINFONAV = "INFO";
			GAMESTATISTICSNAV = "Estad�sticas Juego";
			USERSNAV = "USUARIOS";
			SEARCHUSERNAV = "Buscar Usuario";
			NEWUSERNAV = "Nuevo Usuario";
			
		}
	}
	
}

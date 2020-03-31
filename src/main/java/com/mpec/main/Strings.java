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
	public static String NOPERMISSION;
	public static String INVALIDCREDENTIALS;
	public static String NOTEMPTYCHOICEBOX;
	public static String NOTEMPTYTEXTFIELD;
	public static String REBOOTAPP;
	public static String ERRORENCRYPTING;
	public static String FILLALLFIELDS;
	public static String USERNAMEEXISTS;
	public static String MAILEXISTS;
	public static String NEWUSERADDED;
	public static String ONLYINTEGERS;
	public static String CHANGESAPPLIED;
	public static String COLLECTIONCREATED;
	public static String COLLECTIONEXISTS;
	public static String COLLECTIONDOESNTEXISTS;
	public static String COLLECTIONRENAMED;

	/**
	 * Menús
	 */
	public static String APPLICATIONMENU;
	public static String DOCUMENTSMENU;
	public static String VIEWMENU;
	public static String LOGOUTMENUITEM;
	public static String EXITMENUITEM;
	public static String NEWMENUITEM;
	public static String SEARCHMENUITEM;
	public static String CONFIGURATIONMENUITEM;
	public static String LANGUAGEMENUITEM;
	public static String VIEWEDITCOLS;

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
	
	/**
	 * Config stage
	 */
	public static String THEMELABEL;
	public static String DARKCHOICE;
	public static String LIGHTCHOICE;
	public static String NEWPASSWORDLABEL;
	
	/**
	 * New Collection Stage
	 */
	public static String NEWCOLLECTION;
	

	static {
		loadStrings();
	}

	public static void loadStrings() {
		if (Constants.language.equalsIgnoreCase("english")) {

			LOGINTITLE = "Backstab Administration Panel - Login";
			USERNAMELABEL = "Username";
			USERNAMEFIELD = "Username...";
			PASSWORDLABEL = "Password";
			PASSWORDFIELD = "Password...";
			LOGINBUTTON = "LOGIN";

			NONETWORKALERT = "Your network is not available, you should check your network availability!";
			NONETWORKTITLE = "Network unavailable!";
			NOPERMISSION = "You don't have permission to use this application!";
			INVALIDCREDENTIALS = "The username/password you entered is/are not valid!";
			NOTEMPTYCHOICEBOX = "You must select one option from the list!";
			NOTEMPTYTEXTFIELD = "You must fill the text field!";
			REBOOTAPP = "We must reboot the app to apply your changes.";
			ERRORENCRYPTING = "We couldn't encrypt the E-Mail. User not inserted...";
			FILLALLFIELDS = "You must fill all fields!";
			USERNAMEEXISTS = "The username you entered already exists!";
			MAILEXISTS = "The E-Mail you entered already exists!";
			NEWUSERADDED = "New user added to the system.";
			ONLYINTEGERS = "Only Integers are allowed on the fields.";
			CHANGESAPPLIED = "Changes applied successfully.";
			COLLECTIONCREATED = "Collection created successfully.";
			COLLECTIONEXISTS = "The name you provided for the collection already exists!";
			COLLECTIONDOESNTEXISTS = "The collection doesn't exists!";
			COLLECTIONRENAMED = "Collection renamed successfully.";
			
			APPLICATIONMENU = "Application";
			DOCUMENTSMENU = "Collections";
			VIEWMENU = "View";
			LOGOUTMENUITEM = "Logout";
			EXITMENUITEM = "Exit";
			SEARCHMENUITEM = "Search...";
			NEWMENUITEM = "New...";
			CONFIGURATIONMENUITEM = "Configuration";
			LANGUAGEMENUITEM = "Language";
			VIEWEDITCOLS = "View/Edit collections";

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
			SENDBUTTON = "SEND";

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
			
			THEMELABEL = "Choose a Theme";
			DARKCHOICE = "Dark";
			LIGHTCHOICE = "Light";
			NEWPASSWORDLABEL = "New Password: ";
			
			NEWCOLLECTION = "New collection: ";

		} else if (Constants.language.equalsIgnoreCase("español")) {

			LOGINTITLE = "Administración de Backstab - Iniciar sesión";
			USERNAMELABEL = "Nombre de usuario";
			USERNAMEFIELD = "Nombre de usuario...";
			PASSWORDLABEL = "Contraseña";
			PASSWORDFIELD = "Contraseña...";
			LOGINBUTTON = "Iniciar Sesión";

			NONETWORKALERT = "No hay conexión a Internet, deberías revisar tu conexión!";
			NONETWORKTITLE = "Internet no disponible!";
			NOPERMISSION = "No tienes permisos para usar esta aplicación!";
			INVALIDCREDENTIALS = "El usuario/contraseña introducidos son incorrectos!";
			NOTEMPTYCHOICEBOX = "Debes seleccionar un elemento de la lista!";
			NOTEMPTYTEXTFIELD = "Debes rellenar el campo de texto!";
			REBOOTAPP = "Debemos reiniciar la aplicación para aplicar los cambios.";
			ERRORENCRYPTING = "No hemos podido encriptar el correo electrónico. El usuario no se ha creado...";
			FILLALLFIELDS = "Debes rellenar todos los campos!";
			USERNAMEEXISTS = "El nombre de usuario introducido ya existe!";
			MAILEXISTS = "El correo electrónico introducido ya existe!";
			NEWUSERADDED = "Nuevo usuario añadido al sistema.";
			ONLYINTEGERS = "Solo se permiten números enteros en los campos.";
			CHANGESAPPLIED = "Cambios insertados correctamente.";
			COLLECTIONCREATED = "Colección creada con éxito.";
			COLLECTIONEXISTS = "El nombre proporcionado para la nueva colección ya existe!";
			COLLECTIONDOESNTEXISTS = "La colección no existe!";
			COLLECTIONRENAMED = "Colección renombrada correctamente.";
			 
			APPLICATIONMENU = "Aplicación";
			DOCUMENTSMENU = "Colecciones";
			VIEWMENU = "Ver";
			LOGOUTMENUITEM = "Cerrar sesión";
			EXITMENUITEM = "Salir";
			SEARCHMENUITEM = "Buscar...";
			NEWMENUITEM = "Nuevo...";
			CONFIGURATIONMENUITEM = "Configuración";
			LANGUAGEMENUITEM = "Idioma";
			VIEWEDITCOLS = "Ver/Editar colecciones";

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
			COLUMNDURATION = "Duración (Segundos)";
			COLUMNMINRANGE = "Rango Mínimo";
			COLUMNMAXRANGE = "Rango Máximo";

			PHASETIME = "Tiempo de Fase";
			MINDROPTIME = "Tiempo Mínimo de Drop";
			MAXDROPTIME = "Tiempo Máximo de Drop";
			MONSTERSCOUNT = "Número Base de Monstruos";
			COLLISIONPROB = "Probabilidad de Objetos de Colisión";
			APPLYBUTTON = "Aplicar";

			GAMENAME = "Nombre:";
			TOTALGAMES = "Juegos totales:";
			TOTALPLAYERS = "Jugadores totales:";
			AVERAGETIME = "Promedio de tiempo de juego:";
			AVERAGEDMGDEALT = "Promedio de daño hecho:";
			AVERAGEDMGRECEIVED = "Promedio de daño recibido:";
			AVERAGEDROPSPICKED = "Promedio de drops recogidos:";
			REFRESHBUTTON = "Actualizar";

			FIELDLABEL = "Selecciona el Campo";
			NAMECHOICE = "Nombre";
			SURNAMECHOICE = "Apellido";
			USERNAMECHOICE = "Nombre de usuario";
			MAILCHOICE = "Correo Electrónico";
			VALUELABEL = "Inserta el Valor";
			SEARCHBUTTON = "BUSCAR";

			NAMELABEL = "Nombre";
			SURNAMELABEL = "Apellido";
			MAILLABEL = "Correo Electrónico";
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
			GAMESTATISTICSNAV = "Estadísticas Juego";
			USERSNAV = "USUARIOS";
			SEARCHUSERNAV = "Buscar Usuario";
			NEWUSERNAV = "Nuevo Usuario";

			THEMELABEL = "Escoge un tema:";
			DARKCHOICE = "Oscuro";
			LIGHTCHOICE = "Claro";
			NEWPASSWORDLABEL = "Contraseña Nueva: ";
			
			NEWCOLLECTION = "Nueva Colección: ";
		}
	}
}

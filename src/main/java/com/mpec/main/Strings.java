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
	
	/**
	 * Contenido
	 */
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
			
			APPLICATIONMENU = "Application";
			DOCUMENTSMENU = "Documents";
			VIEWMENU = "View";
			LOGOUTMENUITEM = "Logout";
			EXITMENUITEM = "Exit";
			SEARCHMENUITEM = "Search...";
			NEWMENUITEM = "New...";
			CONFIGURATIONMENUITEM = "Configuration";
			
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
			LOGINTITLE = "Administración de Backstab - Iniciar sesión";
			USERNAMELABEL = "Nombre de usuario";
			USERNAMEFIELD = "Nombre de usuario...";
			PASSWORDLABEL = "Contraseña";
			PASSWORDFIELD = "Contraseña...";
			LOGINBUTTON = "Iniciar Sesión";
			
			NONETWORKALERT = "No hay conexión a Internet, deberías revisar tu conexión!";
			NONETWORKTITLE = "Internet no disponible!";
			
			APPLICATIONMENU = "Aplicación";
			DOCUMENTSMENU = "Documentos";
			VIEWMENU = "Ver";
			LOGOUTMENUITEM = "Cerrar sesión";
			EXITMENUITEM = "Salir";
			SEARCHMENUITEM = "Buscar...";
			NEWMENUITEM = "Nuevo...";
			CONFIGURATIONMENUITEM = "Configuración";
			
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
		}
	}
	
}

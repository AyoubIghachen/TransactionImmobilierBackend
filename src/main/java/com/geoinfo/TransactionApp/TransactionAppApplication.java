package com.geoinfo.TransactionApp;

import com.geoinfo.TransactionApp.entities.Annonce;
import com.geoinfo.TransactionApp.entities.Demande;
import com.geoinfo.TransactionApp.entities.User_role.Citoyen;
import com.geoinfo.TransactionApp.entities.User_role.Intermediaire;
import com.geoinfo.TransactionApp.enums.*;
import com.geoinfo.TransactionApp.reposirory.AnnonceRepository;
import com.geoinfo.TransactionApp.reposirory.DemandeRepository;
import com.geoinfo.TransactionApp.reposirory.User_repository.CitoyenRepository;
import com.geoinfo.TransactionApp.reposirory.User_repository.IntermediaireRepository;
import com.geoinfo.TransactionApp.reposirory.UtilisateurRepository;
import com.geoinfo.TransactionApp.services.DemandeService;
import com.geoinfo.TransactionApp.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TransactionAppApplication implements CommandLineRunner {

	@Autowired
	private AnnonceRepository annonceRepository ;

	@Autowired
	private DemandeService demandeService;

	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private DemandeRepository demandeRepository;

	@Autowired
	private IntermediaireRepository intermediaireRepository;

	@Autowired
	private CitoyenRepository citoyenRepository;

	public static void main(String[] args) {
		SpringApplication.run(TransactionAppApplication.class, args);
		System.out.println("hellow");
	}

	@Override
	public void run(String... args) throws Exception {

		Intermediaire intermediaire1 =new Intermediaire();
		intermediaire1.setEmail("oday@gmail.com");
		intermediaire1.setPassword("oday2001");

		intermediaireRepository.save(intermediaire1);


		Citoyen annonceur= new Citoyen();
		annonceur.setNom("achraf");
		annonceur.setPrenom("belhadaoui");
		annonceur.setEmail("annonceur@gmail.com");
		annonceur.setPassword("annonceur123");

		Citoyen demandeur= new Citoyen();
		demandeur.setNom("Ayoub");
		demandeur.setPrenom("Ighachen");
		demandeur.setEmail("demandeur@gmail.com");
		demandeur.setPassword("demandeur123");

		Citoyen demandeur1= new Citoyen();
		demandeur1.setEmail("demandeur1@gmail.com");
		demandeur1.setNom("Abdelhaq");
		demandeur1.setPrenom("Aouane");
		demandeur1.setPassword("demandeur123");

		Citoyen demandeur2= new Citoyen();
		demandeur2.setEmail("demandeur2@gmail.com");
		demandeur2.setNom("Marouane");
		demandeur2.setPrenom("Oukacha");
		demandeur2.setPassword("demandeur123");

		citoyenRepository.save(annonceur);
		citoyenRepository.save(demandeur);
		citoyenRepository.save(demandeur1);
		citoyenRepository.save(demandeur2);


		/*

		Demandeur demandeur1= Demandeur.builder()
				.email("demandeur1@gmail.com")
				.nom("demandeur1")
				.password("demandeur1")
				.build();

		Utilisateur demandeur2= Demandeur.builder()
				.email("demandeur2@gmail.com")
				.nom("demandeur2")
				.password("demandeur2")
				.build();


		utilisateurService.ajouter_utilisateur(intermediaire1);
		utilisateurService.ajouter_utilisateur(intermediaire1);

		utilisateurService.ajouter_utilisateur(citoyen1);
		utilisateurService.ajouter_utilisateur(citoyen2);

		utilisateurService.ajouter_utilisateur(demandeur1);
		utilisateurService.ajouter_utilisateur(demandeur2);

		 */



		String[][] annonces = {
				{"Casablanca", "33.5333", "-7.5833", "220mk2"},
				{"Mosquée Hassan II", "33.6086", "-7.6328", "non disponible"},
				{"Marché central de Casablanca", "33.5945", "-7.6135", "non disponible"},
				{"Corniche de Casablanca", "33.5966", "-7.7019", "non disponible"},
				{"Ain Diab", "33.5905", "-7.7143", "non disponible"},
				{"Anfa", "33.5918", "-7.6604", "non disponible"},
				{"La Sqala", "33.6059", "-7.6245", "non disponible"},
				{"Cathédrale du Sacré-Cœur de Casablanca", "33.5936", "-7.6199", "non disponible"},
				{"Casablanca Twin Center", "33.5889", "-7.6323", "non disponible"},
				{"Musée Abderrahman Slaoui", "33.5863", "-7.6262", "non disponible"},
				{"Complexe Culturel Sidi Belyout", "33.5913", "-7.6118", "non disponible"},
				{"Bd Mohammed V", "33.5942", "-7.6176", "non disponible"},
				{"Plage Lalla Meryem", "33.5949", "-7.7372", "non disponible"},
				{"Boulevard d'Anfa", "33.5926", "-7.6417", "non disponible"},
				{"Quartier des Habous (Nouvelle Médina)", "33.5841", "-7.6138", "non disponible"},
				{"Parc Sindibad", "33.5512", "-7.6218", "non disponible"},
				{"Marrakech", "31.6295", "-7.9811", "500mk2"},
				{"Place Jemaa el-Fna", "31.6256", "-7.9891", "non disponible"},
				{"Jardin Majorelle", "31.6342", "-7.9881",  "non disponible"},
				{"Palais de la Bahia", "31.6218",  "-7.9814", "non disponible"},
				{"Medersa Ben Youssef", "31.6315",  "-7.9899",  "non disponible"},
				{"Musée de Marrakech", "31.6306", "-7.9893",  "non disponible"},

				{"Rabat", "34.020882", "-6.841650", "180mk2"},
				{"Tour Hassan", "34.0224", "-6.8365", "non disponible"},
				{"Kasbah des Oudaias", "34.0264", "-6.8316", "non disponible"},
				{"Mausolée Mohammed V", "34.0168", "-6.8356", "non disponible"},
				{"Jardins Exotiques de Bouknadel", "33.9932", "-6.9268", "non disponible"},
				{"Plage de Rabat", "34.0132", "-6.8309", "non disponible"},
				{"Musée Mohammed VI d'Art Moderne et Contemporain", "34.0107", "-6.8327", "non disponible"},
				{"Plage des Nations", "34.0087", "-6.8213", "non disponible"},
				{"Complexe Al Amal", "34.0192", "-6.8137", "non disponible"},
				{"Chellah", "34.0227", "-6.8335", "non disponible"},
				{"Royal Golf Dar Es Salam", "34.0091", "-6.8329", "non disponible"},
				{"Parlement du Maroc", "34.0175", "-6.8343", "non disponible"},
				{"Jardin d'essais botaniques de Rabat", "34.0125", "-6.8372", "non disponible"},
				{"Villa des Arts", "33.9905", "-6.8121", "non disponible"},
				{"Musée Belghazi", "34.0187", "-6.8386", "non disponible"},
				{"Museum Mohamed VI of Modern and Contemporary Art", "34.0107", "-6.8327", "non disponible"},
				{"Bibliothèque Nationale du Royaume du Maroc", "34.0119", "-6.8431", "non disponible"},
				{"La Grotte de Chellah", "34.0264", "-6.8316", "non disponible"},
				{"Marché central de Rabat", "34.0247", "-6.8334", "non disponible"},
				{"Plage de Skhirat", "33.6833", "-7.0333", "non disponible"},
				{"Centre Culturel de la Fondation ONA", "34.0135", "-6.8235", "non disponible"},

				{"Fès", "34.0345", "-5.0166", "300mk2"},
				{"Place Boujloud", "34.0592", "-4.9767", "non disponible"},
				{"Médina de Fès el Bali", "34.0734", "-4.9447", "non disponible"},
				{"Bab Bou Jeloud (Porte Bleue)", "34.0674", "-4.9736", "non disponible"},
				{"Borj Nord & Borj Sud", "34.0535", "-4.9982", "non disponible"},
				{"Université Al Quaraouiyine", "34.0738", "-4.9661", "non disponible"},
				{"Médersa Bou Inania", "34.0617", "-4.9764", "non disponible"},
				{"Jardin Jnan Sbil", "34.0669", "-4.9674", "non disponible"},
				{"Musée Nejjarine", "34.0626", "-4.9793", "non disponible"},
				{"Tombeau des Merinides", "34.0782", "-4.9891", "non disponible"},
				{"Palais Royal de Fès", "34.0436", "-4.9995", "non disponible"},
				{"Bab Rcif", "34.0663", "-4.9786", "non disponible"},
				{"Fontaine Amri", "34.0665", "-4.9749", "non disponible"},
				{"Borj Fez Mall", "34.0242", "-5.0118", "non disponible"},
				{"Bab Guissa", "34.0772", "-4.9884", "non disponible"},
				{"Musée Dar Batha", "34.0657", "-4.9744", "non disponible"},
				{"Borj Nord Clock Tower", "34.0556", "-4.9985", "non disponible"},
				{"Parc Agdal", "34.0243", "-4.9904", "non disponible"},
				{"Borj Sud Park", "34.0512", "-4.9986", "non disponible"},
				{"Centre Commercial Borj Fes", "34.0391", "-4.9969", "non disponible"},
				{"Complexe sportif Moulay Abdellah", "34.0368", "-4.9777", "non disponible"},

				{"Tangier", "35.7595", "-5.8330", "400mk2"},
				{"Place du Grand Socco", "35.7774", "-5.8106", "non disponible"},
				{"Kasbah de Tanger", "35.7796", "-5.8125", "non disponible"},
				{"Cap Spartel", "35.7787", "-5.9566", "non disponible"},
				{"Plage de Tanger", "35.7658", "-5.8130", "non disponible"},
				{"Grottes d'Hercule", "35.7717", "-5.9357", "non disponible"},
				{"Musée de la Kasbah", "35.7840", "-5.8145", "non disponible"},
				{"Parc Perdicaris", "35.7929", "-5.8323", "non disponible"},
				{"Port de Tanger Ville", "35.7761", "-5.7913", "non disponible"},
				{"Mosquée Sidi Bou Abib", "35.7641", "-5.8097", "non disponible"},
				{"Plage Municipale", "35.7747", "-5.8087", "non disponible"},
				{"Café Hafa", "35.7775", "-5.8129", "non disponible"},
				{"Cimetière Américain de Tanger", "35.7645", "-5.9231", "non disponible"},
				{"Grand Mosquée de Tanger", "35.7845", "-5.8134", "non disponible"},
				{"Cape Malabata", "35.7967", "-5.7930", "non disponible"},
				{"Plage Achakkar", "35.8182", "-5.8164", "non disponible"},
				{"Place de la France", "35.7678", "-5.8115", "non disponible"},
				{"Hôtel Continental", "35.7745", "-5.7997", "non disponible"},
				{"Phare de Tanger", "35.7940", "-5.7880", "non disponible"},
				{"Tanger City Mall", "35.7675", "-5.8118", "non disponible"},
				{"Parc Rmilat", "35.7741", "-5.8238", "non disponible"},

				{"Agadir", "30.4202", "-9.5981", "550mk2"},
				{"Plage d'Agadir", "30.4202", "-9.5980", "non disponible"},
				{"Kasbah d'Agadir Oufella", "30.4271", "-9.6040", "non disponible"},
				{"Souk El Had d'Agadir", "30.4171", "-9.5979", "non disponible"},
				{"Marina d'Agadir", "30.4217", "-9.6096", "non disponible"},
				{"Vallée des Oiseaux", "30.4161", "-9.6011", "non disponible"},
				{"Musée du Patrimoine Amazigh", "30.4182", "-9.5955", "non disponible"},
				{"Jardin Ibn Zaidoun", "30.4220", "-9.6130", "non disponible"},
				{"La Médina d'Agadir", "30.4260", "-9.5989", "non disponible"},
				{"Crocoparc", "30.4074", "-9.5717", "non disponible"},
				{"Plage de Taghazout", "30.5333", "-9.7167", "non disponible"},
				{"Agadir Birds Valley", "30.4279", "-9.6015", "non disponible"},
				{"Agadir Memorial Museum", "30.4106", "-9.5881", "non disponible"},
				{"Royal Golf d'Agadir", "30.4337", "-9.6259", "non disponible"},
				{"La Grande Roue d'Agadir", "30.4169", "-9.5970", "non disponible"},
				{"Valley d'Oufella", "30.4243", "-9.5953", "non disponible"},
				{"La Grande Mosquée Mohamed V", "30.4119", "-9.5913", "non disponible"},
				{"Crocoparc Agadir", "30.4074", "-9.5717", "non disponible"},
				{"Parc Olhão", "30.4198", "-9.5978", "non disponible"},
				{"Agadir Beach Club", "30.4187", "-9.6045", "non disponible"},
				{"Aquaparc Agadir", "30.4232", "-9.5965", "non disponible"},

				{"Essaouira", "31.5085", "-9.7595", "250mk2"},
				{"Port d'Essaouira", "31.5085", "-9.7686", "non disponible"},
				{"Médina d'Essaouira", "31.5134", "-9.7651", "non disponible"},
				{"Plage d'Essaouira", "31.5093", "-9.7689", "non disponible"},
				{"Skala du Port", "31.5097", "-9.7689", "non disponible"},
				{"Remparts d'Essaouira", "31.5155", "-9.7719", "non disponible"},
				{"Sidi Mohammed Ben Abdallah Museum", "31.5122", "-9.7653", "non disponible"},
				{"Bordj El Berod", "31.5099", "-9.7682", "non disponible"},
				{"Sidi Mghait Beach", "31.5192", "-9.7548", "non disponible"},
				{"Le marché aux poissons", "31.5094", "-9.7688", "non disponible"},
				{"Fontaine d'eau de mer", "31.5127", "-9.7683", "non disponible"},
				{"Bab Sbaa", "31.5106", "-9.7652", "non disponible"},
				{"Synagogue d'Essaouira", "31.5140", "-9.7649", "non disponible"},
				{"Moulay Hassan Square", "31.5117", "-9.7657", "non disponible"},
				{"Dar Souiri", "31.5114", "-9.7661", "non disponible"},
				{"Le jardin Majorelle d'Essaouira", "31.5059", "-9.7740", "non disponible"},
				{"Plage de Sidi Kaouki", "31.3473", "-9.7988", "non disponible"},
				{"Borj El Baroud", "31.5112", "-9.7673", "non disponible"},
				{"Thuya Wood Carving Cooperative", "31.5128", "-9.7629", "non disponible"},
				{"Ounagha", "31.4885", "-9.6951", "non disponible"},
				{"Plage de Diabat", "31.5089", "-9.7832", "non disponible"},

				{"Chefchaouen", "35.1715", "-5.2694", "150mk2"},
				{"Place Outa el Hammam", "35.1697", "-5.2634", "non disponible"},
				{"La Grande Mosquée", "35.1719", "-5.2632", "non disponible"},
				{"Ras Elma Park", "35.1685", "-5.2642", "non disponible"},
				{"Kasbah Museum", "35.1681", "-5.2622", "non disponible"},
				{"Spanish Mosque", "35.1844", "-5.2892", "non disponible"},
				{"Cascades d'Akchour", "35.2613", "-5.0153", "non disponible"},
				{"Souika Street", "35.1701", "-5.2599", "non disponible"},
				{"Chefchaouen Medina", "35.1702", "-5.2631", "non disponible"},
				{"Lina Riad and Spa", "35.1734", "-5.2638", "non disponible"},
				{"Jebel El-Kalaa", "35.1668", "-5.2628", "non disponible"},
				{"Plaza Uta el-Hammam", "35.1687", "-5.2635", "non disponible"},
				{"Talassemtane National Park", "35.0517", "-5.0124", "non disponible"},
				{"Ras El Maa Waterfall", "35.1740", "-5.2731", "non disponible"},
				{"Jardin Jnan Sbil", "35.1681", "-5.2668", "non disponible"},
				{"Akchour Bridge", "35.2737", "-5.0361", "non disponible"},
				{"Hammam Ras El Maa", "35.1775", "-5.2710", "non disponible"},
				{"Casa Aladdin", "35.1674", "-5.2618", "non disponible"},
				{"Rif Mountain Viewpoint", "35.1694", "-5.2566", "non disponible"},
				{"Park Al Yasmine", "35.1696", "-5.2676", "non disponible"},
				{"Spanish Mosque Viewpoint", "35.1843", "-5.2891", "non disponible"},

				{"Ouarzazate", "30.9406", "-6.9102", "700mk2"},
				{"Erfoud", "31.4333", "-4.2500", "800mk2"},
				{"Meknes", "33.8833", "-5.5333", "320mk2"},
				{"Tétouan", "35.5729", "-5.3683", "210mk2"},
				{"Oujda", "34.6800", "-1.9000", "410mk2"},
				{"El Jadida", "33.2333", "-8.5000", "600mk2"},
				{"Kenitra", "34.2610", "-6.5802", "280mk2"},
				{"Taroudant", "30.4707", "-8.8766", "400mk2"},
				{"Asilah", "35.4650", "-6.0367", "330mk2"},
				{"Nador", "35.1739", "-2.9286", "420mk2"},
				{"Safi", "32.2994", "-9.2372", "510mk2"},
				{"Beni Mellal", "32.3340", "-6.3534", "450mk2"},
				{"Tiznit", "29.7004", "-9.7333", "350mk2"},
				{"Mohammedia", "33.6953", "-7.3899", "410mk2"},
				{"Taza", "34.2167", "-4.0000", "280mk2"},
				{"Al Hoceima", "35.2514", "-3.9372", "370mk2"},
				{"Laâyoune", "27.1536", "-13.2033", "600mk2"},
				{"Khouribga", "32.8833", "-6.9000", "420mk2"},
				{"Berrechid", "33.2670", "-7.5831", "380mk2"},
				{"Taourirt", "34.4167", "-2.9167", "300mk2"},
				{"Figuig", "32.1082", "-1.2295","20mk2"},
				{"Tan-Tan", "28.4403", "-11.1001","50mk2"}
		};

		double nombre_incrementale =1000;
		double surface_incrementale =400;

		for (int i = 0; i < annonces.length; i++) {
			String[] annonce_courante = annonces[i];

			Annonce annonce = Annonce.builder()
					.description("Annonce in " + annonce_courante[0])
					.prix_bien(nombre_incrementale)
					.surface(surface_incrementale)
					.latitude(annonce_courante[1])
					.longitude(annonce_courante[2])
					.type_operation(OperationType.VENDRE)
					.statut(Statut.EN_ATTENTE)
					.etat(Etat.NULL)
					.date_annonce(new Date())
					.annonceur(annonceur)
					.type_bien(BienType.VILLA)
					.build();

			annonceRepository.save(annonce);

			Demande demande = Demande.builder()
					.annonce(annonce)
					.demandeur(demandeur)
					.date_demande(new Date())
					.build();

			demandeRepository.save(demande);

			nombre_incrementale+=2000;
			surface_incrementale-=40;


		}

		Annonce annonce_test = Annonce.builder()
				.description("Annonce in ratbat")
				.prix_bien(5000.6)
				.surface(12000.4)
				.latitude("32.8833")
				.longitude("-6.9000")
				.type_operation(OperationType.VENDRE)
				.statut(Statut.EN_ATTENTE)
				.etat(Etat.NULL)
				.date_annonce(new Date())
				.annonceur(annonceur)
				.type_bien(BienType.VILLA)
				.build();

		annonceRepository.save(annonce_test);

		Demande demande = Demande.builder()
				.annonce(annonce_test)
				.demandeur(demandeur)
				.date_demande(new Date())
				.build();

		Demande demande1 = Demande.builder()
				.annonce(annonce_test)
				.date_demande(new Date())
				.demandeur(demandeur1)
				.build();

		Demande demande2 = Demande.builder()
				.annonce(annonce_test)
				.date_demande(new Date())
				.demandeur(demandeur2)
				.build();

		demandeRepository.save(demande);
		demandeRepository.save(demande1);
		demandeRepository.save(demande2);



		/*

		CommuneInitializer communeInitializer=new CommuneInitializer();
		communeInitializer.importShapefileToPostgreSQL();



		Annonce annonce=Annonce.builder()
				.description("ma premiere annonce")
				.prix_bien(123145.25)
				.surface("220mk2")
				.type_bien("maison")
				.build();

		Annonce annonce_2=Annonce.builder()
				.description("ma deuxieme annonce")
				.prix_bien(1231785.25)
				.surface("500mk2")
				.type_bien("villa")
				.build();

		annonceRepository.save(annonce);
		annonceRepository.save(annonce_2);

		Demande demande1=Demande.builder()
				.annonce(annonce)
				.build();

		demandeRepository.save(demande1);

		List<Annonce> all_annonc = annonceRepository.findAll();
		all_annonc.forEach(a->{
			System.out.println(a.toString());
		});

		System.out.println("-----------------------------------------------");

		List<Annonce> annonces=annonceRepository.findByDescriptionContaining("deuxieme");
		annonces.forEach(a->{
			a.setDemandeForAnnonce(null);
			System.out.println(a);
		});

		System.out.println("-----------------------------------------------");

		List<Annonce> annonces_1=annonceRepository.search("%premiere%");
		annonces_1.forEach(a->{
			System.out.println(a);
		});

		 */








	}
}

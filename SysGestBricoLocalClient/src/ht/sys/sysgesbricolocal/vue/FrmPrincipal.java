/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.vue;

import ht.sys.sysgesbricolocal.main.SysGestBricoLocalClient;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import servicetechnique.Service;

/**
 *
 * @author scharlyne
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    //   InetAddress ida = null;
    // ida = InetAddress.getLocalHost();
    public static Service ser = new servicetechnique.Service();
    private static String enteteFournisseur[] = {"Numero", "Nom", "Adresse", "Telephone", "Telephone1", "Telephone2", "Email", "Email1", "Email2"};
    private static String enteteCategorie[] = {"Numero", "Description", "Date ajout"};
    private static String entetearticle[] = {"Numero", "Description", "Categorie", "Prix unitaire", "Quantite en stock", "Date ajout"};
    private static String entetearticlerechercher[] = {"Numero", "Description", "Categorie", "Prix unitaire", "Quantite en stock", "Date ajout", "Fournisseur"};
    private static String enteteEmploye[] = {"numeroemploye", "nom", "prenom", "sexe", "nif", "datenaissance", "adresse", "dateembauche", "numerodepartement", "fonction", "email", "email1", "telephone", "telephone1", "Salaire"};
    private static String enteteEmployeUtil[] = {"numeroemploye", "nom", "prenom", "departement", "fonction"};
    private static String enteteUtilisateur[] = {"nomutilisateur", "nom", "prenom", "email", "email1", "telephone", "telephone1"};
    private static String enteteUtilisateur1[] = {"nomutilisateur", "etatutilisateur", "etatconnexion", "nommachine", "adressemachine", "role"};
    private static String enteteVente[] = {"Client", "telephone", "Article", "Quantite", "Montant", "Code_Vente", "date_Vente", "Vendeur"};
    private static String tet[] = {"num_article", "description", "px_unitaire", "quantite", "s-total", "vendeur", "Index"};
    private static String entetePayroll[] = {"numero", "nom", "prenom", "salairebrut", "taxe", "salairenet", "mois"};
    private static String enteteHistorique[] = {"nomutilisateur", "tableaffectee", "action", "numeroentite", "date", "heure", "nommachine", "adressemachine"};
    private static String entetePayrollLister[] = {"numeroemploye", "nom", "prenom", "salairebrut", "taxe", "salairenet", "mois", "date"};
    //emp.numeroemploye,emp.nom,emp.prenom,sal.salaire,pay.moispaye,pay.datepayroll
    public static DefaultTableModel modelP;
    private static Object datap[][] = null;
    private static boolean ok = false, gauche = true, droite = false, haut = false, bas = false;

    //emp.numeroemploye,emp.nom,emp.prenom,dep.Departement,emp.fonction
    public static void VenteComboTableau() {
//    SysGestBricoLocalClient.chargerVendeur(cbxNomUtilisateurVendeur, jtChargerVendeur);
//    SysGestBricoLocalClient.chargerDateVente(cbxDateVenteArticle, jtChargerDateVente);
//    SysGestBricoLocalClient.chargerNumeroVente(cbxNumeroVenteArticle, jtChargerNumeroVente);
        SysGestBricoLocalClient.ListerVente(enteteVente, GrilleAffichervente);

    }

    public static void DepartementComboTableau() {
        cbxAffectationEmploye.removeAll();
        cbxAffectationEmploye.addItem("Departement");
        SysGestBricoLocalClient.chargerDepartement(cbxAffectationEmploye, jtChargerFournisseur);
        SysGestBricoLocalClient.chargerDepartement(cbxAffectationRechEmploye, jtChargerFournisseur);
        SysGestBricoLocalClient.chargerNumEmploye(cbxRechercherEmploye, jtChargerNumEmploye);
        SysGestBricoLocalClient.chargerNumEmploye(cbxNumeroEmployeCharger, jtChargerNumEmploye);
    }

    public static void FournisseurComboTableau() {
        cbxRechercherNumeroFournisseur.removeAll();
        cbxRechercherNomFournisseur.removeAll();
        cbFournisseurAjouterArticle.removeAll();
        SysGestBricoLocalClient.chargerfournisseur(cbxRechercherNumeroFournisseur, cbxRechercherNomFournisseur, jtChargerFournisseur);
        SysGestBricoLocalClient.chargerfournisseurArticle(cbFournisseurAjouterArticle, jtChargerFournisseur);
        SysGestBricoLocalClient.ListerFournisseur(enteteFournisseur, grilleFournisseur2);

    }

    public static void FonctionComboTableau() {
        cbFonctionMod1.removeAll();
        cbxFonctionEmploye.removeAll();
        SysGestBricoLocalClient.chargerfonction(cbxFonctionEmploye, jtChargerFonction);
        SysGestBricoLocalClient.chargerfonction(cbFonctionMod1, jtChargerFonction);
        SysGestBricoLocalClient.chargerfonction(cbxFonctionRechEmploye, jtChargerFonction);

    }

    public static void CategorieComboTableau() {
        cbRechercherDescCategorie.removeAll();
        cbRechercherDateAjoutCAtegorie.removeAll();
        CbCategorieAjouterArticle.removeAll();
        SysGestBricoLocalClient.ListerCategorie(enteteCategorie, jtListerCategorie);
        SysGestBricoLocalClient.chargerCategorie(cbRechercherDescCategorie, cbRechercherDateAjoutCAtegorie, jtChargerCategorie);
        SysGestBricoLocalClient.chargerCategorieArticle(CbCategorieAjouterArticle, jtChargerCategorie);
    }

    public static void PayrollComboTableau() {

        SysGestBricoLocalClient.chargerMoisPayroll(cbxRechMoisPayroll, jtChargerMoisPayroll);
        SysGestBricoLocalClient.chargerDatePayroll(cbxRechDatePayroll, jtChargerDatePayrolll);
    }

    public static void DateEmploye() {
        int annee = 1970;
        int jour = 31;
        int mois = 12;
        int i = 0;
        
        for (i = Integer.valueOf(ser.annee); i > annee + 17; i--) {
            cbxAnneeEmbaucheRechEmploye.addItem(i);
            cbxAnneeEmbaucheEmploye.addItem(i);
        }
        for (i = 1997; i > annee; i--) {
            cbxAnneeNaisEmploye.addItem(i);
            cbxAnneeNaisRechEmploye.addItem(i);
        }
        for (i = 1; i <= 9; i++) {
            cbxJourNaisEmploye.addItem("0" + i);
            cbxJourEmbaucheEmploye.addItem("0" + i);
            cbxJourNaisRechEmploye.addItem("0" + i);
            cbxJourEmbaucheRechEmploye.addItem("0" + i);
            cbxMoisNaisEmploye.addItem("0" + i);
            cbxMoisEmbaucheEmploye.addItem("0" + i);
            cbxMoisNaisRechEmploye.addItem("0" + i);
            cbxMoisEmbaucheRechEmploye.addItem("0" + i);
        }
        for (i = 10; i <= jour; i++) {
            cbxJourNaisEmploye.addItem(i);
            cbxJourEmbaucheEmploye.addItem(i);
            cbxJourNaisRechEmploye.addItem(i);
            cbxJourEmbaucheRechEmploye.addItem(i);
        }
        for (i = 10; i <= mois; i++) {
            cbxMoisNaisEmploye.addItem(i);
            cbxMoisEmbaucheEmploye.addItem(i);
            cbxMoisNaisRechEmploye.addItem(i);
            cbxMoisEmbaucheRechEmploye.addItem(i);
        }
    }

    public static void Taxe() {
        try {
            boolean trouve = false;
            trouve = SysGestBricoLocalClient.pre.RechercherPrelevement();
            trouve = true;
            if (trouve) {
                txtTca.setText(SysGestBricoLocalClient.pre.prendreTca().toString());
                txtOna.setText(SysGestBricoLocalClient.pre.prendreOna().toString());
                txtSante.setText(SysGestBricoLocalClient.pre.prendreSante().toString());
                txtVie.setText(SysGestBricoLocalClient.pre.prendreVie().toString());
                txtMort.setText(SysGestBricoLocalClient.pre.prendreMort().toString());

            }
        } catch (Exception e) {
        }
    }

    public static void rechecherEmploye() {
        try {
            //SysGestBricoLocalClient.ListerEmploye(enteteEmployer,grilleRechEmploye );
            boolean trouveemp = false;
            boolean trouvetel = false;
            boolean trouvemail = false;
            boolean trouvesal = false;
            boolean trouvedep = false;
            trouveemp = SysGestBricoLocalClient.emp.RechercherEmployeModifier("BL-Emp769-547");
            numeroEmploye = SysGestBricoLocalClient.emp.prendreNumeroemploye().toString();
            numerodepartement = SysGestBricoLocalClient.emp.prendreNumerodepartement().toString();
            trouvetel = SysGestBricoLocalClient.tel.RechercherTelephoneEmploye(numeroEmploye);
            trouvemail = SysGestBricoLocalClient.ema.RechercherEmailEmploye(numeroEmploye);
            trouvesal = SysGestBricoLocalClient.sal.RechercherSalaireEmployeModifier(numeroEmploye);
            trouvedep = SysGestBricoLocalClient.dep.RechercherDepartement(SysGestBricoLocalClient.emp.prendreNumerodepartement());
            trouveemp = true;
            lblDateNais.setText("");
            lblDateEmbauche.setText("");
            if (trouveemp) {
                txtMatriculeRechEmploye.setText(SysGestBricoLocalClient.emp.prendreNif().toString());
                txNomRechEmploye.setText(SysGestBricoLocalClient.emp.prendreNom().toString());
                txPrenomRechEmploye.setText(SysGestBricoLocalClient.emp.prendrePrenom().toString());
                cbSexeRechEmploye.addItem(SysGestBricoLocalClient.emp.prendreSexe().toString());
                txAdresseRechEmploye.setText(SysGestBricoLocalClient.emp.prendreAdresse().toString());

                lblDateNais.setText("Date naissance:" + SysGestBricoLocalClient.emp.prendreDatenaissance().toString());
                lblDateEmbauche.setText("Date embauche:" + SysGestBricoLocalClient.emp.prendreDateembauche().toString());
                cbxAffectationRechEmploye.setSelectedItem(SysGestBricoLocalClient.dep.prendreDepartement().toString());
                cbxFonctionRechEmploye.setSelectedItem(SysGestBricoLocalClient.emp.prendreFonction().toString());
                cbxSalaireRechEmploye.setSelectedItem(SysGestBricoLocalClient.sal.prendreSalaire().toString());

                txtTelephoneRechEmploye.setText(SysGestBricoLocalClient.tel.prendreTelephone().toString());
                txtTelephoneRechEmploye1.setText(SysGestBricoLocalClient.tel.prendreTelephone1().toString());


                txtEmailRechEmploye.setText(SysGestBricoLocalClient.ema.prendreEmail().toString());
                txtEmailRechEmploye1.setText(SysGestBricoLocalClient.ema.prendreEmail1().toString());


            }
        } catch (Exception e) {
        }
    }

    public static void ArticleComboTableau() {
        cbRechercherDescCategorie.removeAll();
        cbRechercherDateAjoutCAtegorie.removeAll();
        CbCategorieAjouterArticle.removeAllItems();
        cbDescriptionArticleModifier.removeAll();
        //cbNumeroArticleModifier.removeAll();
        cbRecherchersupprimerDescription.removeAll();
        cbRecherchersupprimerNumeroArt.removeAll();

        SysGestBricoLocalClient.ListerArticle(entetearticle, tbListerArticle);
        SysGestBricoLocalClient.chargerArticle(cbRechercherDescription, cbRechercherDateAjout, jtChargerArticle);
        SysGestBricoLocalClient.chargerArticleMod(cbDescriptionArticleModifier, jtChargerArticle);
        SysGestBricoLocalClient.chargerArticleSup(cbRecherchersupprimerDescription, cbRecherchersupprimerNumeroArt, jtChargerArticle);


        // SysGestBricoLocalClient.chargerCategorieArticle(CbCategorieAjouterArticle, jtChargerCategorie);
    }

    public static void UtilisateurComboTableau() {
        SysGestBricoLocalClient.chargerNomUtilisateur(cbxRechercherUtilisateurDB, jtgrilleNom);
        SysGestBricoLocalClient.chargerNomUtilisateur(cbxRechercherUtilisateurNom, jtgrilleNom);
        SysGestBricoLocalClient.chargerNomUtilisateur(cbxNomUtilisateurRechercher, jtgrilleNom);
//        SysGestBricoLocalClient.ChargerAction(cbxTraceAction, jtTraceeAction);
//        SysGestBricoLocalClient.ChargerTableAffectee(cbxTraceEntite, jtTraceeTableAffectee);
//        SysGestBricoLocalClient.ChargerNomUtilisateurTracee(cbxTraceUtilisateur, jtTraceeNomutilisateur);
//        SysGestBricoLocalClient.ChargerDateTracee(cbxTraceDate, jtgrilleNom);

    }

    public static void NettoyerFournisseur() {

        txtNomFournisseur.setText("");
        txtNomFournisseur1.setText("");
        txtAdresselFournisseur.setText("");
        txtEmaillFournisseur.setText("");
        txTelephoneFournisseur.setText("");
        txEmailFournisseur1.setText("");
        txTelephoneFournisseur1.setText("");
        txtAdresselFournisseur.setText("");
        txtTelephoneFourni2.setText("");
        txEmailFournisseur1.setText("");
        txEmailFournisseur2.setText("");
        txAdresseFournisseur1.setText("");
        txEmailFournisseur4.setText("");
        txEmailFournisseur5.setText("");
        txtTelephoneRechFourni1.setText("");
        txtTelephoneRechFourni2.setText("");
    }

    public static void NettoyerOutil() {
        txtFonction1.setText("");
        txtSalairemin.setText("");
        txtQuantiteEmploye.setText("");
        txtSalairemax.setText("");
        txtQuantiteEmployeMod1.setText("");
        txtSalairemin3.setText("");
        txtSalairemax3.setText("");
    }

    public static void NettoyerUtilisateur() {
        txtIndiceRechercheEmployeUtil.setText("");
        txtNomUtilisateur.setText("");
        txtMotPasseUtililisateur.setText("");
        txtRepeterMotpasseUtilRech.setText("");
        txtRechercherUtilisateur.setText("");
        txtNomUtilisateurRech.setText("");
        txtMotPasseUtilRech.setText("");
        txtRepeterMotpasseUtilRech.setText("");
        txtNomUtilisateurRechercherMotdepasse.setText("");
        txtModPasseRechercherMotdepasse.setText("");
        //TxtNomUtilisateurReche.setText("");
        //txtNouveauNomUtilisateur.setText("");
        //txtNouveauNomUtilisateurRepeter.setText("");
        txtAncienMotDePasse.setText("");
        TxtNouveauMotPasse.setText("");
        txtNouveauMotPasserepeter.setText("");
        txtNomUtilisateurRechEtat.setText("");
        txtMatriculeEmploye.setText("");
        txtNomEmploye.setText("");
        txtPrenomEmploye.setText("");
        txtTelephoneEmploye.setText("");
        txtTelephoneEmploye1.setText("");
        txEmailEmploye.setText("");
        txEmailEmploye1.setText("");
        txtIndiceRechercheEmployeUtil.setText("");
        txtMatriculeRechEmploye.setText("");
        txNomRechEmploye.setText("");
        txPrenomRechEmploye.setText("");
        txAdresseRechEmploye.setText("");
        txtTelephoneRechEmploye.setText("");
        txtTelephoneRechEmploye.setText("");

        txtEmailRechEmploye.setText("");
        txtEmailRechEmploye1.setText("");

    }

    public static void NettoyerVente() {
        txtNomClient.setText("");
        txtTelephoneClient.setText("");
        txtAdresseClient.setText("");
        txtEmailClient.setText("");
        txtPrixArticleVente.setText("");
        txMontantRecu.setText("");
        lblNombreArticleVente.setText("");
        lblPrixtotalvente.setText("");
        txMontantRecu.setText("");
        soustotalvente = 0;
        prixtotalvente = 0;
        QuantiteArticletotalvente = 0;
        cbxvt.removeAllItems();
        AjouterLigneVente(tet, grilleVente);
    }

    public static void NettoyerAchat() {
        txDescriptionAchat.setText("");
        txtQuantiteAchat.setText("");
        txtPrixAchat.setText("");
        txFraisAchat.setText("");
        txDescriptionAchatRech.setText("");
        txtQuantiteAchatRech.setText("");

        txtPrixAchatRech.setText("");
        txFraisAchatRech.setText("");
    }

    public static void NettoyerArticle() {
        txtDescriptionArticle.setText("");
        txtQuantiteArticle.setText("");
        txtPrixArticle.setText("");
        txtDescriptionArticleModifier.setText("");
        txQuantiteArticleModifier.setText("");
        txPrixArticleModifier.setText("");
        txFournisseurArticleSupprimer.setText("");
        txCategorieArticleSupprimer.setText("");
        txtDescriptionArticleSupprimer.setText("");
        txQuantiteArticleSupprimer.setText("");
        txPrixArticleSupprimer.setText("");

    }

    public static void NettoyerEmploye() {
        txtNomEmploye.setText("");
        txtPrenomEmploye.setText("");
        txtMatriculeEmploye.setText("");
        txtAdresseEmploye.setText("");
        txtTelephoneEmploye.setText("");
        txtTelephoneEmploye1.setText("");
        txEmailEmploye.setText("");
        txEmailEmploye1.setText("");


    }

    public FrmPrincipal() {
        initComponents();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("C:/icon/bricopied.JPG");
        setIconImage(img);
        //cbxRechercherNumeroFournisseur.removeAllItems();
        FournisseurComboTableau();
        CategorieComboTableau();
        ArticleComboTableau();
        FonctionComboTableau();
        Taxe();
        DateEmploye();
        DepartementComboTableau();
        UtilisateurComboTableau();
        VenteComboTableau();
        PayrollComboTableau();
        SysGestBricoLocalClient.chargerNomArticle(cbxLibelleArticleVente, jtgrilleNomArticle);

        //rechecherEmploye();

    }
    public static String numerofournisseur = "";
    public static String numerofournisseurArticle = "";
    public static String numerofournisseurArticleMod = "";
    public static String numerocategorie = "";
    public static String numeroarticle = "";
    public static String numerostock = "";
    public static String numerovente = "";
    public static String numerodepartement = "";
    public static String numeroEmploye = "";
    public static int numerofonction = 0;
    public static int numerofonctionajouter = 0;
    public static int QuantiteArticle = 0;
    public static String numeroclient = "";
    public static float soustotalvente = 0;
    public static float prixtotalvente = 0;
    public static int QuantiteArticletotalvente = 0;
    public static float qt = 0;
    public static boolean trouveClient = false;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TbArticle = new javax.swing.JTabbedPane();
        Utilisateur = new javax.swing.JTabbedPane();
        panAjouterUtilisateur = new javax.swing.JPanel();
        panRechEmpl1 = new javax.swing.JPanel();
        lblcodearticle37 = new javax.swing.JLabel();
        lblcodearticle38 = new javax.swing.JLabel();
        cbxNumeroEmployeCharger = new javax.swing.JComboBox();
        txtIndiceRechercheEmployeUtil = new javax.swing.JTextField();
        btnRechercherEmployerUtil = new javax.swing.JButton();
        jScrollPane33 = new javax.swing.JScrollPane();
        jtRechEmployeUtil = new javax.swing.JTable();
        panCorpsEnregistrerUtil = new javax.swing.JPanel();
        lblerreurnomarticle11 = new javax.swing.JLabel();
        btnAjouterUtilisateur = new javax.swing.JButton();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jSeparator35 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtNomUtilisateur = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtRepeterMotpasseUtilisateur = new javax.swing.JPasswordField();
        txtMotPasseUtililisateur = new javax.swing.JPasswordField();
        cbRoleUtilisateur = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        cbEtatUtilisateur = new javax.swing.JComboBox();
        lblMessageUtilisateur = new javax.swing.JLabel();
        PanRechercherUtilisateur = new javax.swing.JPanel();
        panRechUtilisateur = new javax.swing.JPanel();
        lblcodearticle39 = new javax.swing.JLabel();
        lblcodearticle40 = new javax.swing.JLabel();
        cbxRechercherUtilisateurNom = new javax.swing.JComboBox();
        txtRechercherUtilisateur = new javax.swing.JTextField();
        panCorpsRechUtilisateur = new javax.swing.JPanel();
        lblerreurnomarticle14 = new javax.swing.JLabel();
        lblerreurprixarticle9 = new javax.swing.JLabel();
        btnModifierUtilisateur = new javax.swing.JButton();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jSeparator36 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtNomUtilisateurRech = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtRepeterMotpasseUtilRech = new javax.swing.JPasswordField();
        txtMotPasseUtilRech = new javax.swing.JPasswordField();
        jLabel30 = new javax.swing.JLabel();
        lbMessageUtilisateurRech = new javax.swing.JLabel();
        cbRoleUtilisateurRechecher = new javax.swing.JComboBox();
        cbEtatUtilisateurRechercher = new javax.swing.JComboBox();
        panChangerMotpasse = new javax.swing.JPanel();
        panRechUtilisateurMod = new javax.swing.JPanel();
        lblNomUtilisateur = new javax.swing.JLabel();
        lblcodearticle42 = new javax.swing.JLabel();
        txtNomUtilisateurRechercherMotdepasse = new javax.swing.JTextField();
        txtModPasseRechercherMotdepasse = new javax.swing.JPasswordField();
        btnRechercherMotdepasse = new javax.swing.JButton();
        panCorpsEnregistrerUtil1 = new javax.swing.JPanel();
        lblerreurnomarticle15 = new javax.swing.JLabel();
        lblerreurprixarticle10 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jSeparator37 = new javax.swing.JSeparator();
        lblMessageUtilisateur1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnModifierMotPasse = new javax.swing.JButton();
        txtAncienMotDePasse = new javax.swing.JPasswordField();
        TxtNouveauMotPasse = new javax.swing.JPasswordField();
        txtNouveauMotPasserepeter = new javax.swing.JPasswordField();
        panEtatUtilisateur = new javax.swing.JPanel();
        jScrollPane36 = new javax.swing.JScrollPane();
        GrilleEtatUtilisateur = new javax.swing.JTable();
        panCorpsRechUtilisateur1 = new javax.swing.JPanel();
        lblerreurnomarticle16 = new javax.swing.JLabel();
        lblerreurprixarticle11 = new javax.swing.JLabel();
        BtDebloquerUtilisateur = new javax.swing.JButton();
        BtBloquerUtilisateur = new javax.swing.JButton();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jSeparator38 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtNomUtilisateurRechEtat = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        lbMessageMessageUtil1 = new javax.swing.JLabel();
        txtRoleUtilisateurRechEtat = new javax.swing.JTextField();
        txtEtatUtilisateurRechEtat = new javax.swing.JTextField();
        lblcodearticle43 = new javax.swing.JLabel();
        cbxRechercherUtilisateurDB = new javax.swing.JComboBox();
        panListerUtilisateur = new javax.swing.JPanel();
        panRechEmpl2 = new javax.swing.JPanel();
        cbxNomUtilisateurRechercher = new javax.swing.JComboBox();
        btnListerUtilisateur = new javax.swing.JButton();
        cbxEtatUtilisateurRechercher = new javax.swing.JComboBox();
        cbxEtatConnexionUtilisateurRechercher = new javax.swing.JComboBox();
        cbxroleUtilisateurRechercher = new javax.swing.JComboBox();
        jScrollPane40 = new javax.swing.JScrollPane();
        grilleUtilisateur1 = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        grilleUtilisateur2 = new javax.swing.JTable();
        Employe = new javax.swing.JTabbedPane();
        panEmbaucherEmploye = new javax.swing.JPanel();
        panCorpsEmploye = new javax.swing.JPanel();
        lblcodearticle14 = new javax.swing.JLabel();
        lblnomarticle11 = new javax.swing.JLabel();
        txtNomEmploye = new javax.swing.JTextField();
        lblnomarticle12 = new javax.swing.JLabel();
        lblerreurnomarticle7 = new javax.swing.JLabel();
        txtPrenomEmploye = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtMatriculeEmploye = new javax.swing.JTextField();
        lblnomarticle13 = new javax.swing.JLabel();
        lblnomarticle14 = new javax.swing.JLabel();
        txtAdresseEmploye = new javax.swing.JTextField();
        cbxSexeEmploye = new javax.swing.JComboBox();
        lblcodearticle15 = new javax.swing.JLabel();
        lblcodearticle16 = new javax.swing.JLabel();
        lblcodearticle17 = new javax.swing.JLabel();
        lblcodearticle18 = new javax.swing.JLabel();
        lblcodearticle19 = new javax.swing.JLabel();
        cbxJourEmbaucheEmploye = new javax.swing.JComboBox();
        cbxMoisEmbaucheEmploye = new javax.swing.JComboBox();
        cbxAnneeEmbaucheEmploye = new javax.swing.JComboBox();
        cbxAnneeNaisEmploye = new javax.swing.JComboBox();
        cbxMoisNaisEmploye = new javax.swing.JComboBox();
        cbxJourNaisEmploye = new javax.swing.JComboBox();
        cbxAffectationEmploye = new javax.swing.JComboBox();
        cbxFonctionEmploye = new javax.swing.JComboBox();
        cbxSalaireEmploye = new javax.swing.JComboBox();
        jPanel22 = new javax.swing.JPanel();
        lbltelephonefournissuer5 = new javax.swing.JLabel();
        lblemail5 = new javax.swing.JLabel();
        txEmailEmploye = new javax.swing.JTextField();
        lbltelephonefournissuer6 = new javax.swing.JLabel();
        txEmailEmploye1 = new javax.swing.JTextField();
        lblemail6 = new javax.swing.JLabel();
        txtTelephoneEmploye1 = new javax.swing.JTextField();
        txtTelephoneEmploye = new javax.swing.JTextField();
        lblMessageEmploye = new javax.swing.JLabel();
        btnenregistrerEmploye = new javax.swing.JButton();
        panModifierEmploye = new javax.swing.JPanel();
        panCorpsRechEmpl = new javax.swing.JPanel();
        lblcodearticle22 = new javax.swing.JLabel();
        lblnomarticle15 = new javax.swing.JLabel();
        txNomRechEmploye = new javax.swing.JTextField();
        lblnomarticle16 = new javax.swing.JLabel();
        lblerreurnomarticle8 = new javax.swing.JLabel();
        txPrenomRechEmploye = new javax.swing.JTextField();
        lblMessageEmployeModifier = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        txtMatriculeRechEmploye = new javax.swing.JTextField();
        lblnomarticle17 = new javax.swing.JLabel();
        lblnomarticle18 = new javax.swing.JLabel();
        txAdresseRechEmploye = new javax.swing.JTextField();
        cbSexeRechEmploye = new javax.swing.JComboBox();
        lblDateNais = new javax.swing.JLabel();
        lblDateEmbauche = new javax.swing.JLabel();
        lblcodearticle25 = new javax.swing.JLabel();
        lblcodearticle26 = new javax.swing.JLabel();
        lblcodearticle27 = new javax.swing.JLabel();
        cbxJourEmbaucheRechEmploye = new javax.swing.JComboBox();
        cbxMoisEmbaucheRechEmploye = new javax.swing.JComboBox();
        cbxAnneeEmbaucheRechEmploye = new javax.swing.JComboBox();
        cbxAnneeNaisRechEmploye = new javax.swing.JComboBox();
        cbxMoisNaisRechEmploye = new javax.swing.JComboBox();
        cbxJourNaisRechEmploye = new javax.swing.JComboBox();
        cbxAffectationRechEmploye = new javax.swing.JComboBox();
        cbxFonctionRechEmploye = new javax.swing.JComboBox();
        cbxSalaireRechEmploye = new javax.swing.JComboBox();
        jPanel23 = new javax.swing.JPanel();
        lbltelephonefournissuer7 = new javax.swing.JLabel();
        txtEmailRechEmploye = new javax.swing.JTextField();
        lbltelephonefournissuer8 = new javax.swing.JLabel();
        txtEmailRechEmploye1 = new javax.swing.JTextField();
        lblemail8 = new javax.swing.JLabel();
        txtTelephoneRechEmploye1 = new javax.swing.JTextField();
        txtTelephoneRechEmploye = new javax.swing.JTextField();
        lblemail7 = new javax.swing.JLabel();
        btnModifierEmploye = new javax.swing.JButton();
        btnSupprimerEmploye = new javax.swing.JButton();
        cbxRechercherEmploye = new javax.swing.JComboBox();
        btnRechercherEmp = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane31 = new javax.swing.JScrollPane();
        grilleRechEmploye = new javax.swing.JTable();
        lblcodearticle20 = new javax.swing.JLabel();
        txtRechercherEmployerIndice = new javax.swing.JTextField();
        btnAfficherEmploye = new javax.swing.JButton();
        lblTotalEmploye = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Fournisseur = new javax.swing.JTabbedPane();
        panAjouterFournisseur1 = new javax.swing.JPanel();
        panCorpsFournisseur = new javax.swing.JPanel();
        lblMessageFournisseur = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel19 = new javax.swing.JPanel();
        lbltelephonefournissuer = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        txEmailFournisseur1 = new javax.swing.JTextField();
        lbltelephonefournissuer3 = new javax.swing.JLabel();
        txEmailFournisseur2 = new javax.swing.JTextField();
        lblemail3 = new javax.swing.JLabel();
        txtTelephoneFourni2 = new javax.swing.JTextField();
        txTelephoneFournisseur1 = new javax.swing.JTextField();
        txtNomFournisseur = new javax.swing.JTextField();
        lblcodearticle10 = new javax.swing.JLabel();
        lblnomarticle7 = new javax.swing.JLabel();
        txTelephoneFournisseur = new javax.swing.JTextField();
        txtEmaillFournisseur = new javax.swing.JTextField();
        lblnomarticle8 = new javax.swing.JLabel();
        txtAdresselFournisseur = new javax.swing.JTextField();
        lblnomarticle23 = new javax.swing.JLabel();
        panAjouterFournisseur = new javax.swing.JPanel();
        btnajouterFournisseur = new javax.swing.JButton();
        panRecherchercherFournisseur = new javax.swing.JPanel();
        jPanel79 = new javax.swing.JPanel();
        lblcodearticle11 = new javax.swing.JLabel();
        cbxRechercherNomFournisseur = new javax.swing.JComboBox();
        lblcodearticle12 = new javax.swing.JLabel();
        cbxRechercherNumeroFournisseur = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtChargerFournisseur = new javax.swing.JTable();
        panCorpsFournisseur1 = new javax.swing.JPanel();
        lblerreurnomarticle6 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel20 = new javax.swing.JPanel();
        lbltelephonefournissuer1 = new javax.swing.JLabel();
        lblemail1 = new javax.swing.JLabel();
        txEmailFournisseur4 = new javax.swing.JTextField();
        lbltelephonefournissuer4 = new javax.swing.JLabel();
        txEmailFournisseur5 = new javax.swing.JTextField();
        lblemail4 = new javax.swing.JLabel();
        txtTelephoneRechFourni1 = new javax.swing.JTextField();
        txtTelephoneRechFourni2 = new javax.swing.JTextField();
        panAjouterFournisseur2 = new javax.swing.JPanel();
        btnSupprimerFournisseur = new javax.swing.JButton();
        btModifierFournisseur = new javax.swing.JButton();
        panFourniss = new javax.swing.JPanel();
        lblcodearticle13 = new javax.swing.JLabel();
        txtNomFournisseur1 = new javax.swing.JTextField();
        txTelephoneFournisseur2 = new javax.swing.JTextField();
        lblnomarticle9 = new javax.swing.JLabel();
        txEmailFournisseur3 = new javax.swing.JTextField();
        lblnomarticle10 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        txAdresseFournisseur1 = new javax.swing.JTextPane();
        lblMessageModifierFournisseur = new javax.swing.JLabel();
        PanListerFournisseur = new javax.swing.JPanel();
        jScrollPane30 = new javax.swing.JScrollPane();
        grilleFournisseur2 = new javax.swing.JTable();
        Categorie = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        panCorpsAjouterProduit3 = new javax.swing.JPanel();
        lblerreurnomarticle3 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        txtCategorie = new javax.swing.JTextPane();
        btAjouterCategorie = new javax.swing.JButton();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        LblMessageCategorie = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        panRechercherCategorie = new javax.swing.JPanel();
        panCorpsCategorie = new javax.swing.JPanel();
        lblerreurnomarticle4 = new javax.swing.JLabel();
        lblerreurprixarticle4 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        txtCategorieRechercher = new javax.swing.JTextPane();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        btSupprimerCategorie = new javax.swing.JButton();
        btModifierCategorie = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtNumeroCategorieRechercher = new javax.swing.JTextField();
        jScrollPane25 = new javax.swing.JScrollPane();
        jtListerCategorie = new javax.swing.JTable();
        cbRechercherDescCategorie = new javax.swing.JComboBox();
        lblcodearticle3 = new javax.swing.JLabel();
        lblcodearticle9 = new javax.swing.JLabel();
        cbRechercherDateAjoutCAtegorie = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtChargerCategorie = new javax.swing.JTable();
        Achat = new javax.swing.JTabbedPane();
        panEnregistrerAchat = new javax.swing.JPanel();
        panCorpsAchat = new javax.swing.JPanel();
        lblcodearticle28 = new javax.swing.JLabel();
        lblnomarticle19 = new javax.swing.JLabel();
        txtQuantiteAchat = new javax.swing.JTextField();
        lblnomarticle20 = new javax.swing.JLabel();
        lblerreurnomarticle10 = new javax.swing.JLabel();
        txtPrixAchat = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jSeparator28 = new javax.swing.JSeparator();
        txDescriptionAchat = new javax.swing.JTextField();
        lblnomarticle21 = new javax.swing.JLabel();
        lblnomarticle22 = new javax.swing.JLabel();
        cbFournisseurAchat = new javax.swing.JComboBox();
        txFraisAchat = new javax.swing.JTextField();
        btnenregistrerAchat = new javax.swing.JButton();
        panRechercherAchat = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        lblcodearticle29 = new javax.swing.JLabel();
        cbRechercherDescriptionAchat = new javax.swing.JComboBox();
        lblcodearticle30 = new javax.swing.JLabel();
        cbRechercherDateAjoutAchat = new javax.swing.JComboBox();
        panCorpsAchatRech = new javax.swing.JPanel();
        lblcodearticle32 = new javax.swing.JLabel();
        lblnomarticle27 = new javax.swing.JLabel();
        txtQuantiteAchatRech = new javax.swing.JTextField();
        lblnomarticle28 = new javax.swing.JLabel();
        lblerreurnomarticle12 = new javax.swing.JLabel();
        txtPrixAchatRech = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jSeparator31 = new javax.swing.JSeparator();
        txDescriptionAchatRech = new javax.swing.JTextField();
        lblnomarticle29 = new javax.swing.JLabel();
        lblnomarticle30 = new javax.swing.JLabel();
        cbFournisseurARech = new javax.swing.JComboBox();
        txFraisAchatRech = new javax.swing.JTextField();
        btnModifierAchat = new javax.swing.JButton();
        btnSupprimerAchat = new javax.swing.JButton();
        jScrollPane32 = new javax.swing.JScrollPane();
        grilleAchat1 = new javax.swing.JTable();
        Article = new javax.swing.JPanel();
        TbAjouterArticle = new javax.swing.JTabbedPane();
        panArticle = new javax.swing.JPanel();
        panAjouterArtcile = new javax.swing.JPanel();
        panCorpsAjouterProduit = new javax.swing.JPanel();
        lblcategorie = new javax.swing.JLabel();
        lblcodearticle = new javax.swing.JLabel();
        lblnomarticle = new javax.swing.JLabel();
        CbCategorieAjouterArticle = new javax.swing.JComboBox();
        lblnomarticle1 = new javax.swing.JLabel();
        lblerreurnomarticle = new javax.swing.JLabel();
        txtPrixArticle = new javax.swing.JTextField();
        cbFournisseurAjouterArticle = new javax.swing.JComboBox();
        jScrollPane16 = new javax.swing.JScrollPane();
        txtDescriptionArticle = new javax.swing.JTextPane();
        BtAjouterArticle = new javax.swing.JButton();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtQuantiteArticle = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        panRechercherArticle = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        lblcodearticle1 = new javax.swing.JLabel();
        cbRechercherDescription = new javax.swing.JComboBox();
        lblcodearticle4 = new javax.swing.JLabel();
        cbRechercherDateAjout = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtChargerArticle = new javax.swing.JTable();
        jScrollPane19 = new javax.swing.JScrollPane();
        tbArticleRechercher = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        lblcodearticle36 = new javax.swing.JLabel();
        cbDescriptionArticleModifier = new javax.swing.JComboBox();
        panCorpsAjouterProduit4 = new javax.swing.JPanel();
        lblcategorie4 = new javax.swing.JLabel();
        lblcodearticle41 = new javax.swing.JLabel();
        lblnomarticle5 = new javax.swing.JLabel();
        txQuantiteArticleModifier = new javax.swing.JTextField();
        CbCategorieArticleModifier = new javax.swing.JComboBox();
        lblnomarticle24 = new javax.swing.JLabel();
        lblerreurnomarticle9 = new javax.swing.JLabel();
        txPrixArticleModifier = new javax.swing.JTextField();
        lblerreurprixarticle3 = new javax.swing.JLabel();
        cbFournisseurSupprimer1 = new javax.swing.JComboBox();
        jScrollPane37 = new javax.swing.JScrollPane();
        txtDescriptionArticleModifier = new javax.swing.JTextPane();
        BtModifierArticle = new javax.swing.JButton();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        panSupprimerArticle = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        lblcodearticle6 = new javax.swing.JLabel();
        cbRecherchersupprimerNumeroArt = new javax.swing.JComboBox();
        lblcodearticle7 = new javax.swing.JLabel();
        cbRecherchersupprimerDescription = new javax.swing.JComboBox();
        panCorpsAjouterProduit2 = new javax.swing.JPanel();
        lblcategorie3 = new javax.swing.JLabel();
        lblcodearticle8 = new javax.swing.JLabel();
        lblnomarticle4 = new javax.swing.JLabel();
        txQuantiteArticleSupprimer = new javax.swing.JTextField();
        lblnomarticle6 = new javax.swing.JLabel();
        lblerreurnomarticle2 = new javax.swing.JLabel();
        txPrixArticleSupprimer = new javax.swing.JTextField();
        lblerreurprixarticle2 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        txtDescriptionArticleSupprimer = new javax.swing.JTextPane();
        BtSupprimerArticle = new javax.swing.JButton();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        txFournisseurArticleSupprimer = new javax.swing.JTextField();
        txCategorieArticleSupprimer = new javax.swing.JTextField();
        panAfficherArticleStock = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        tbListerArticle = new javax.swing.JTable();
        Payroll = new javax.swing.JTabbedPane();
        panEffectuerPayroll = new javax.swing.JPanel();
        pantetepayroll = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxMoisPayroll = new javax.swing.JComboBox();
        lblMessagePayroll = new javax.swing.JLabel();
        panPreparerPaiement1 = new javax.swing.JPanel();
        btnEffectuerPayroll = new javax.swing.JButton();
        lblMontantTotalPayroll = new javax.swing.JLabel();
        lblNombreEmployeCharger = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        GrillePreparerPayroll = new javax.swing.JTable();
        panRechPayroll = new javax.swing.JPanel();
        cbxRechMoisPayroll = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        grilleRechPayroll = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cbxRechDatePayroll = new javax.swing.JComboBox();
        btnAfficherPayroll = new javax.swing.JButton();
        Vente = new javax.swing.JTabbedPane();
        panEffectuerVente = new javax.swing.JPanel();
        panCorpsEffectuerVente3 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jSeparator34 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtNomClient = new javax.swing.JTextField();
        txtTelephoneClient = new javax.swing.JTextField();
        txtAdresseClient = new javax.swing.JTextField();
        panSaisieArticle = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        cbxLibelleArticleVente = new javax.swing.JComboBox();
        jLabel83 = new javax.swing.JLabel();
        txtPrixArticleVente = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        label12 = new java.awt.Label();
        lblNombreArticleVente = new java.awt.Label();
        label13 = new java.awt.Label();
        lblPrixtotalvente = new java.awt.Label();
        label14 = new java.awt.Label();
        txMontantRecu = new javax.swing.JTextField();
        btnValiderVente = new javax.swing.JButton();
        btnVenteVente = new javax.swing.JButton();
        btnAjouterLigneVente = new javax.swing.JButton();
        txtQuantiteArticleVente = new javax.swing.JTextField();
        txtEmailClient = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        grilleVente = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cbxRetirerArticleVente = new javax.swing.JComboBox();
        btnRetirerArticleVente = new javax.swing.JButton();
        lblMessageVente = new java.awt.Label();
        lblMessageClient = new javax.swing.JLabel();
        panRechercherVente = new javax.swing.JPanel();
        panrechVente = new javax.swing.JPanel();
        lblcodearticle34 = new javax.swing.JLabel();
        txtNumeroVenteArticle = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        Grillerechvente = new javax.swing.JTable();
        panAfficherVente = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        GrilleAffichervente = new javax.swing.JTable();
        Outils = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        panCorpsOutilsEmploye2 = new javax.swing.JPanel();
        lblerreurnomarticle17 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jSeparator32 = new javax.swing.JSeparator();
        jPanel70 = new javax.swing.JPanel();
        lbltelephonefournissuer15 = new javax.swing.JLabel();
        lblemail14 = new javax.swing.JLabel();
        txtFonction1 = new javax.swing.JTextField();
        txtQuantiteEmploye = new javax.swing.JTextField();
        btnEnregistrerFonction1 = new javax.swing.JButton();
        txtSalairemin = new javax.swing.JTextField();
        txtSalairemax = new javax.swing.JTextField();
        lblemail11 = new javax.swing.JLabel();
        lbltelephonefournissuer11 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        lblemail15 = new javax.swing.JLabel();
        txtQuantiteEmployeMod1 = new javax.swing.JTextField();
        btnModifierFonction1 = new javax.swing.JButton();
        cbFonctionMod1 = new javax.swing.JComboBox();
        btnSupprimerFonction1 = new javax.swing.JButton();
        txtSalairemax3 = new javax.swing.JTextField();
        lblemail12 = new javax.swing.JLabel();
        lbltelephonefournissuer12 = new javax.swing.JLabel();
        txtSalairemin3 = new javax.swing.JTextField();
        panPrelevement1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtOna = new javax.swing.JTextField();
        txtTca = new javax.swing.JTextField();
        txtSante = new javax.swing.JTextField();
        txtMort = new javax.swing.JTextField();
        txtVie = new javax.swing.JTextField();
        btnModifierTaxe = new javax.swing.JButton();
        lblTeteDepartement = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAjouterDepartement = new javax.swing.JTextField();
        btnAjouterDepartement = new javax.swing.JButton();
        cbxModifierDepartement = new javax.swing.JComboBox();
        jScrollPane39 = new javax.swing.JScrollPane();
        txtModifierDepartement = new javax.swing.JTextPane();
        btnModifierDepartement = new javax.swing.JButton();
        btnSupprimerDepartement = new javax.swing.JButton();
        panHistorique = new javax.swing.JPanel();
        btnTraceUtilisateur = new javax.swing.JButton();
        jScrollPane38 = new javax.swing.JScrollPane();
        jtTracee = new javax.swing.JTable();
        txtIndiceTracee = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        panTete = new javax.swing.JPanel();
        barreoutils = new javax.swing.JToolBar();
        btnQuitterApplication = new javax.swing.JButton();
        jSeparator23 = new javax.swing.JToolBar.Separator();
        btnDeconnecter = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JToolBar.Separator();
        btnChagerMotPasseUt = new javax.swing.JButton();
        jSeparator21 = new javax.swing.JToolBar.Separator();
        btnEmploye = new javax.swing.JButton();
        jSeparator17 = new javax.swing.JToolBar.Separator();
        btnPayroll = new javax.swing.JButton();
        jSeparator19 = new javax.swing.JToolBar.Separator();
        btnOutil = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        btnArticle = new javax.swing.JButton();
        jSeparator22 = new javax.swing.JToolBar.Separator();
        btnVente = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btnFournisseur = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        btnCategorie = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        btnAchat = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        btnMenuGauche = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        btnMenuHaut = new javax.swing.JButton();
        jSeparator24 = new javax.swing.JToolBar.Separator();
        btnMenuDroite = new javax.swing.JButton();
        jSeparator30 = new javax.swing.JToolBar.Separator();
        lblUtilisateurconnecter = new javax.swing.JLabel();
        panpiedImage = new javax.swing.JPanel();
        lblPied1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblPied2 = new javax.swing.JLabel();
        panCorpsConnexion = new javax.swing.JPanel();
        panConnexion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomUtilisateurConn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnConnecter = new javax.swing.JButton();
        btnQuitterConnexion = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtMotdemasseConn = new javax.swing.JPasswordField();
        lblMessageConn = new javax.swing.JLabel();
        lblPied = new javax.swing.JLabel();
        lblTeteConnexion = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        JtChagerDepartement = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtChargerFonction = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jtChargerNumEmploye = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        jtgrilleNom = new javax.swing.JTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        jtChargerUtilisateur = new javax.swing.JTable();
        cbxLigneVente = new javax.swing.JComboBox();
        jScrollPane27 = new javax.swing.JScrollPane();
        jtgrilleNomArticle = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        cbxvt = new javax.swing.JComboBox();
        jScrollPane29 = new javax.swing.JScrollPane();
        jtChargerVendeur = new javax.swing.JTable();
        jScrollPane34 = new javax.swing.JScrollPane();
        jtChargerDateVente = new javax.swing.JTable();
        jScrollPane35 = new javax.swing.JScrollPane();
        jtChargerNumeroVente = new javax.swing.JTable();
        jScrollPane41 = new javax.swing.JScrollPane();
        jtTraceeDate = new javax.swing.JTable();
        jScrollPane42 = new javax.swing.JScrollPane();
        jtTraceeAction = new javax.swing.JTable();
        jScrollPane43 = new javax.swing.JScrollPane();
        jtTraceeTableAffectee = new javax.swing.JTable();
        jScrollPane23 = new javax.swing.JScrollPane();
        jtTraceeNomutilisateur = new javax.swing.JTable();
        jScrollPane44 = new javax.swing.JScrollPane();
        jtChargerMoisPayroll = new javax.swing.JTable();
        jScrollPane45 = new javax.swing.JScrollPane();
        jtChargerDatePayrolll = new javax.swing.JTable();
        BMnMenuPrincipal = new javax.swing.JMenuBar();
        mnUtilisateur = new javax.swing.JMenu();
        mnEmploye = new javax.swing.JMenu();
        mnFournisseur = new javax.swing.JMenu();
        mnCategorie = new javax.swing.JMenu();
        mnArticle = new javax.swing.JMenu();
        mnPayroll = new javax.swing.JMenu();
        mnAchat = new javax.swing.JMenu();
        MnVente = new javax.swing.JMenu();
        mnOutil = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SYSGESBRICOLOCAL");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        TbArticle.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        TbArticle.setToolTipText("");
        TbArticle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Utilisateur.setBackground(new java.awt.Color(255, 255, 255));
        Utilisateur.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        panAjouterUtilisateur.setBackground(new java.awt.Color(255, 255, 255));

        panRechEmpl1.setBackground(new java.awt.Color(255, 255, 255));
        panRechEmpl1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recherche d'employe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcodearticle37.setText("Taper indice de reherche");
        lblcodearticle37.setToolTipText("Entrer numero ou nom ou prenom ou telephone ou fonction de l'employe");

        lblcodearticle38.setText("Choisir Numero Employe");

        cbxNumeroEmployeCharger.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir" }));
        cbxNumeroEmployeCharger.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxNumeroEmployeChargerItemStateChanged(evt);
            }
        });

        txtIndiceRechercheEmployeUtil.setToolTipText("Entrer numero ou nom ou prenom ou telephone ou fonction de l'employe");
        txtIndiceRechercheEmployeUtil.setSelectionColor(new java.awt.Color(255, 204, 0));
        txtIndiceRechercheEmployeUtil.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtIndiceRechercheEmployeUtilCaretUpdate(evt);
            }
        });

        btnRechercherEmployerUtil.setText("Rechercher");
        btnRechercherEmployerUtil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercherEmployerUtilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panRechEmpl1Layout = new javax.swing.GroupLayout(panRechEmpl1);
        panRechEmpl1.setLayout(panRechEmpl1Layout);
        panRechEmpl1Layout.setHorizontalGroup(
            panRechEmpl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRechEmpl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panRechEmpl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle38, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxNumeroEmployeCharger, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panRechEmpl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle37)
                    .addGroup(panRechEmpl1Layout.createSequentialGroup()
                        .addComponent(txtIndiceRechercheEmployeUtil, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRechercherEmployerUtil)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        panRechEmpl1Layout.setVerticalGroup(
            panRechEmpl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panRechEmpl1Layout.createSequentialGroup()
                .addGroup(panRechEmpl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panRechEmpl1Layout.createSequentialGroup()
                        .addComponent(lblcodearticle37, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panRechEmpl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIndiceRechercheEmployeUtil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRechercherEmployerUtil)))
                    .addGroup(panRechEmpl1Layout.createSequentialGroup()
                        .addComponent(lblcodearticle38, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxNumeroEmployeCharger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jtRechEmployeUtil.setAutoCreateRowSorter(true);
        jtRechEmployeUtil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "numero", "Nom", "Prenom", "Sexe", "nif", "date naissance", "dateembauche", "departement affecte", "Fonction"
            }
        ));
        jScrollPane33.setViewportView(jtRechEmployeUtil);

        panCorpsEnregistrerUtil.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsEnregistrerUtil.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saisir utilisateur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblerreurnomarticle11.setForeground(new java.awt.Color(255, 0, 0));

        btnAjouterUtilisateur.setBackground(new java.awt.Color(204, 204, 204));
        btnAjouterUtilisateur.setText("Ajouter");
        btnAjouterUtilisateur.setEnabled(false);
        btnAjouterUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterUtilisateurActionPerformed(evt);
            }
        });

        jLabel118.setBackground(new java.awt.Color(0, 0, 0));
        jLabel118.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(255, 153, 0));
        jLabel118.setText("Local");
        jLabel118.setToolTipText("");

        jLabel119.setBackground(new java.awt.Color(0, 0, 0));
        jLabel119.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(255, 153, 0));
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("Brico");
        jLabel119.setToolTipText("");
        jLabel119.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator35.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator35.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator35.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel21.setText("Nom utilisateur");

        jLabel22.setText("Role utilisateur");

        txtNomUtilisateur.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomUtilisateurCaretUpdate(evt);
            }
        });

        jLabel23.setText("Mot de passe");

        jLabel24.setText("Repeter mot de passe");

        txtRepeterMotpasseUtilisateur.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtRepeterMotpasseUtilisateurCaretUpdate(evt);
            }
        });

        txtMotPasseUtililisateur.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMotPasseUtililisateurCaretUpdate(evt);
            }
        });

        cbRoleUtilisateur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Comptable", "Directeur Achat", "Directeur vente", "Caissier", "Directeur Administratif", "Administrateur" }));

        jLabel25.setText("Etat Utilisateur");

        cbEtatUtilisateur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bloque", "Debloque" }));

        javax.swing.GroupLayout panCorpsEnregistrerUtilLayout = new javax.swing.GroupLayout(panCorpsEnregistrerUtil);
        panCorpsEnregistrerUtil.setLayout(panCorpsEnregistrerUtilLayout);
        panCorpsEnregistrerUtilLayout.setHorizontalGroup(
            panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsEnregistrerUtilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMessageUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panCorpsEnregistrerUtilLayout.createSequentialGroup()
                        .addGroup(panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsEnregistrerUtilLayout.createSequentialGroup()
                                .addGroup(panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtRepeterMotpasseUtilisateur, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                        .addComponent(txtMotPasseUtililisateur, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNomUtilisateur, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel23))
                                .addGap(18, 18, 18)
                                .addGroup(panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel22)
                                    .addComponent(cbRoleUtilisateur, 0, 217, Short.MAX_VALUE)
                                    .addComponent(cbEtatUtilisateur, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAjouterUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel24))
                        .addGap(0, 118, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerreurnomarticle11, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator35, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel118)
                    .addComponent(jLabel119)))
        );
        panCorpsEnregistrerUtilLayout.setVerticalGroup(
            panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsEnregistrerUtilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblerreurnomarticle11, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(panCorpsEnregistrerUtilLayout.createSequentialGroup()
                .addGroup(panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsEnregistrerUtilLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator35, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panCorpsEnregistrerUtilLayout.createSequentialGroup()
                                .addGroup(panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbRoleUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMotPasseUtililisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbEtatUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCorpsEnregistrerUtilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRepeterMotpasseUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAjouterUtilisateur))
                                .addGap(18, 18, 18)
                                .addComponent(lblMessageUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panCorpsEnregistrerUtilLayout.createSequentialGroup()
                        .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panAjouterUtilisateurLayout = new javax.swing.GroupLayout(panAjouterUtilisateur);
        panAjouterUtilisateur.setLayout(panAjouterUtilisateurLayout);
        panAjouterUtilisateurLayout.setHorizontalGroup(
            panAjouterUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane33, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
            .addComponent(panCorpsEnregistrerUtil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panAjouterUtilisateurLayout.createSequentialGroup()
                .addComponent(panRechEmpl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panAjouterUtilisateurLayout.setVerticalGroup(
            panAjouterUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAjouterUtilisateurLayout.createSequentialGroup()
                .addComponent(panRechEmpl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCorpsEnregistrerUtil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        Utilisateur.addTab("Ajouter", panAjouterUtilisateur);

        PanRechercherUtilisateur.setBackground(new java.awt.Color(255, 255, 255));

        panRechUtilisateur.setBackground(new java.awt.Color(255, 255, 255));
        panRechUtilisateur.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recherche utilisateur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcodearticle39.setText("Taper indice de reherche");
        lblcodearticle39.setToolTipText("Entrer numero ou nom ou prenom ou telephone ou fonction de l'employe");

        lblcodearticle40.setText("Choisir Nom utilisateur");

        cbxRechercherUtilisateurNom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir" }));
        cbxRechercherUtilisateurNom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxRechercherUtilisateurNomItemStateChanged(evt);
            }
        });

        txtRechercherUtilisateur.setToolTipText("Entrer numero ou nom ou prenom ou telephone ou fonction de l'employe");
        txtRechercherUtilisateur.setSelectionColor(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout panRechUtilisateurLayout = new javax.swing.GroupLayout(panRechUtilisateur);
        panRechUtilisateur.setLayout(panRechUtilisateurLayout);
        panRechUtilisateurLayout.setHorizontalGroup(
            panRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRechUtilisateurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle40, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxRechercherUtilisateurNom, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle39)
                    .addComponent(txtRechercherUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        panRechUtilisateurLayout.setVerticalGroup(
            panRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRechUtilisateurLayout.createSequentialGroup()
                .addGroup(panRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panRechUtilisateurLayout.createSequentialGroup()
                        .addComponent(lblcodearticle39, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRechercherUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panRechUtilisateurLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(cbxRechercherUtilisateurNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblcodearticle40, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panCorpsRechUtilisateur.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsRechUtilisateur.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saisir utilisateur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblerreurnomarticle14.setForeground(new java.awt.Color(255, 0, 0));

        lblerreurprixarticle9.setForeground(new java.awt.Color(255, 0, 0));

        btnModifierUtilisateur.setBackground(new java.awt.Color(204, 204, 204));
        btnModifierUtilisateur.setText("Modifier");
        btnModifierUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierUtilisateurActionPerformed(evt);
            }
        });

        jLabel120.setBackground(new java.awt.Color(0, 0, 0));
        jLabel120.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 153, 0));
        jLabel120.setText("Local");
        jLabel120.setToolTipText("");

        jLabel121.setBackground(new java.awt.Color(0, 0, 0));
        jLabel121.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 153, 0));
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setText("Brico");
        jLabel121.setToolTipText("");
        jLabel121.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator36.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator36.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator36.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel26.setText("Nom utilisateur");

        jLabel27.setText("Role utilisateur");

        txtNomUtilisateurRech.setEditable(false);

        jLabel28.setText("Mot de passe");

        jLabel29.setText("Repeter mot de passe");

        txtRepeterMotpasseUtilRech.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtRepeterMotpasseUtilRechCaretUpdate(evt);
            }
        });

        txtMotPasseUtilRech.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMotPasseUtilRechCaretUpdate(evt);
            }
        });

        jLabel30.setText("Etat Utilisateur");

        cbRoleUtilisateurRechecher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Comptable", "Directeur Achat", "Directeur vente", "Caissier", "Directeur Administratif", "Administrateur" }));

        cbEtatUtilisateurRechercher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bloque", "Debloque" }));

        javax.swing.GroupLayout panCorpsRechUtilisateurLayout = new javax.swing.GroupLayout(panCorpsRechUtilisateur);
        panCorpsRechUtilisateur.setLayout(panCorpsRechUtilisateurLayout);
        panCorpsRechUtilisateurLayout.setHorizontalGroup(
            panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsRechUtilisateurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMessageUtilisateurRech, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panCorpsRechUtilisateurLayout.createSequentialGroup()
                        .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtRepeterMotpasseUtilRech, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                .addComponent(txtMotPasseUtilRech, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNomUtilisateurRech, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsRechUtilisateurLayout.createSequentialGroup()
                                .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel27))
                                .addGap(0, 224, Short.MAX_VALUE))
                            .addComponent(cbRoleUtilisateurRechecher, 0, 295, Short.MAX_VALUE)
                            .addComponent(cbEtatUtilisateurRechercher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModifierUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsRechUtilisateurLayout.createSequentialGroup()
                        .addComponent(lblerreurprixarticle9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panCorpsRechUtilisateurLayout.createSequentialGroup()
                        .addComponent(lblerreurnomarticle14, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jSeparator36, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel121)
                            .addComponent(jLabel120))
                        .addContainerGap(46, Short.MAX_VALUE))))
        );
        panCorpsRechUtilisateurLayout.setVerticalGroup(
            panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsRechUtilisateurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsRechUtilisateurLayout.createSequentialGroup()
                        .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsRechUtilisateurLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCorpsRechUtilisateurLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel120, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsRechUtilisateurLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblerreurnomarticle14, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46))))
                            .addGroup(panCorpsRechUtilisateurLayout.createSequentialGroup()
                                .addComponent(jSeparator36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(lblerreurprixarticle9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCorpsRechUtilisateurLayout.createSequentialGroup()
                        .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomUtilisateurRech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRoleUtilisateurRechecher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMotPasseUtilRech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEtatUtilisateurRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsRechUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panCorpsRechUtilisateurLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRepeterMotpasseUtilRech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnModifierUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbMessageUtilisateurRech, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout PanRechercherUtilisateurLayout = new javax.swing.GroupLayout(PanRechercherUtilisateur);
        PanRechercherUtilisateur.setLayout(PanRechercherUtilisateurLayout);
        PanRechercherUtilisateurLayout.setHorizontalGroup(
            PanRechercherUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanRechercherUtilisateurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanRechercherUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panRechUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCorpsRechUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanRechercherUtilisateurLayout.setVerticalGroup(
            PanRechercherUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanRechercherUtilisateurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panRechUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCorpsRechUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        Utilisateur.addTab("Modifier", PanRechercherUtilisateur);

        panChangerMotpasse.setBackground(new java.awt.Color(255, 255, 255));

        panRechUtilisateurMod.setBackground(new java.awt.Color(255, 255, 255));
        panRechUtilisateurMod.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recherche utilisateur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblNomUtilisateur.setText("Entrer nom utilisateur");
        lblNomUtilisateur.setToolTipText("Entrer numero ou nom ou prenom ou telephone ou fonction de l'employe");

        lblcodearticle42.setText("Entrer mot de passe");

        txtNomUtilisateurRechercherMotdepasse.setToolTipText("Entrer numero ou nom ou prenom ou telephone ou fonction de l'employe");
        txtNomUtilisateurRechercherMotdepasse.setSelectionColor(new java.awt.Color(255, 204, 0));

        btnRechercherMotdepasse.setText("Recherher");
        btnRechercherMotdepasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercherMotdepasseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panRechUtilisateurModLayout = new javax.swing.GroupLayout(panRechUtilisateurMod);
        panRechUtilisateurMod.setLayout(panRechUtilisateurModLayout);
        panRechUtilisateurModLayout.setHorizontalGroup(
            panRechUtilisateurModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRechUtilisateurModLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panRechUtilisateurModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomUtilisateur)
                    .addComponent(txtNomUtilisateurRechercherMotdepasse, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panRechUtilisateurModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle42, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panRechUtilisateurModLayout.createSequentialGroup()
                        .addComponent(txtModPasseRechercherMotdepasse, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRechercherMotdepasse, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panRechUtilisateurModLayout.setVerticalGroup(
            panRechUtilisateurModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRechUtilisateurModLayout.createSequentialGroup()
                .addComponent(lblNomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panRechUtilisateurModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomUtilisateurRechercherMotdepasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModPasseRechercherMotdepasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRechercherMotdepasse)))
            .addComponent(lblcodearticle42, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panCorpsEnregistrerUtil1.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsEnregistrerUtil1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saisir utilisateur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblerreurnomarticle15.setForeground(new java.awt.Color(255, 0, 0));

        lblerreurprixarticle10.setForeground(new java.awt.Color(255, 0, 0));

        jLabel122.setBackground(new java.awt.Color(0, 0, 0));
        jLabel122.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 153, 0));
        jLabel122.setText("Local");
        jLabel122.setToolTipText("");

        jLabel123.setBackground(new java.awt.Color(0, 0, 0));
        jLabel123.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 153, 0));
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("Brico");
        jLabel123.setToolTipText("");
        jLabel123.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator37.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator37.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator37.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Modification de mot de passe"));

        jLabel12.setText("Taper mot de passe");

        jLabel13.setText("Enter nouveau mot de passe");

        jLabel16.setText("Repeter nouveau mot de passe");

        btnModifierMotPasse.setText("Modifier");
        btnModifierMotPasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierMotPasseActionPerformed(evt);
            }
        });

        TxtNouveauMotPasse.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TxtNouveauMotPasseCaretUpdate(evt);
            }
        });

        txtNouveauMotPasserepeter.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNouveauMotPasserepeterCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(txtAncienMotDePasse, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(TxtNouveauMotPasse, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(txtNouveauMotPasserepeter, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(btnModifierMotPasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAncienMotDePasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtNouveauMotPasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNouveauMotPasserepeter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnModifierMotPasse)
                .addContainerGap())
        );

        javax.swing.GroupLayout panCorpsEnregistrerUtil1Layout = new javax.swing.GroupLayout(panCorpsEnregistrerUtil1);
        panCorpsEnregistrerUtil1.setLayout(panCorpsEnregistrerUtil1Layout);
        panCorpsEnregistrerUtil1Layout.setHorizontalGroup(
            panCorpsEnregistrerUtil1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsEnregistrerUtil1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(panCorpsEnregistrerUtil1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMessageUtilisateur1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsEnregistrerUtil1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(panCorpsEnregistrerUtil1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsEnregistrerUtil1Layout.createSequentialGroup()
                        .addComponent(lblerreurprixarticle10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panCorpsEnregistrerUtil1Layout.createSequentialGroup()
                        .addComponent(lblerreurnomarticle15, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jSeparator37, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panCorpsEnregistrerUtil1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel123)
                            .addComponent(jLabel122))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        panCorpsEnregistrerUtil1Layout.setVerticalGroup(
            panCorpsEnregistrerUtil1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsEnregistrerUtil1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerreurprixarticle10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsEnregistrerUtil1Layout.createSequentialGroup()
                .addGroup(panCorpsEnregistrerUtil1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panCorpsEnregistrerUtil1Layout.createSequentialGroup()
                        .addComponent(jSeparator37)
                        .addGap(18, 18, 18)
                        .addComponent(lblerreurnomarticle15, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCorpsEnregistrerUtil1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(lblMessageUtilisateur1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panChangerMotpasseLayout = new javax.swing.GroupLayout(panChangerMotpasse);
        panChangerMotpasse.setLayout(panChangerMotpasseLayout);
        panChangerMotpasseLayout.setHorizontalGroup(
            panChangerMotpasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChangerMotpasseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panChangerMotpasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panRechUtilisateurMod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCorpsEnregistrerUtil1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panChangerMotpasseLayout.setVerticalGroup(
            panChangerMotpasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChangerMotpasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panRechUtilisateurMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panCorpsEnregistrerUtil1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(162, 162, 162))
        );

        Utilisateur.addTab("Changer", panChangerMotpasse);

        panEtatUtilisateur.setBackground(new java.awt.Color(255, 255, 255));

        GrilleEtatUtilisateur.setAutoCreateRowSorter(true);
        GrilleEtatUtilisateur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nom utilisateur", "Bloque", "Debloque", "Fonction"
            }
        ));
        jScrollPane36.setViewportView(GrilleEtatUtilisateur);

        panCorpsRechUtilisateur1.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsRechUtilisateur1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saisir utilisateur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblerreurnomarticle16.setForeground(new java.awt.Color(255, 0, 0));

        lblerreurprixarticle11.setForeground(new java.awt.Color(255, 0, 0));

        BtDebloquerUtilisateur.setBackground(new java.awt.Color(204, 204, 204));
        BtDebloquerUtilisateur.setText("Debloquer");
        BtDebloquerUtilisateur.setEnabled(false);
        BtDebloquerUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtDebloquerUtilisateurActionPerformed(evt);
            }
        });

        BtBloquerUtilisateur.setBackground(new java.awt.Color(204, 204, 204));
        BtBloquerUtilisateur.setText("Bloquer");
        BtBloquerUtilisateur.setEnabled(false);
        BtBloquerUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBloquerUtilisateurActionPerformed(evt);
            }
        });

        jLabel124.setBackground(new java.awt.Color(0, 0, 0));
        jLabel124.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 153, 0));
        jLabel124.setText("Local");
        jLabel124.setToolTipText("");

        jLabel125.setBackground(new java.awt.Color(0, 0, 0));
        jLabel125.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 153, 0));
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setText("Brico");
        jLabel125.setToolTipText("");
        jLabel125.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator38.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator38.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator38.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel31.setText("Nom utilisateur");

        jLabel32.setText("Role utilisateur");

        txtNomUtilisateurRechEtat.setEditable(false);

        jLabel35.setText("Etat Utilisateur");

        txtRoleUtilisateurRechEtat.setEditable(false);

        txtEtatUtilisateurRechEtat.setEditable(false);

        javax.swing.GroupLayout panCorpsRechUtilisateur1Layout = new javax.swing.GroupLayout(panCorpsRechUtilisateur1);
        panCorpsRechUtilisateur1.setLayout(panCorpsRechUtilisateur1Layout);
        panCorpsRechUtilisateur1Layout.setHorizontalGroup(
            panCorpsRechUtilisateur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsRechUtilisateur1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsRechUtilisateur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMessageMessageUtil1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panCorpsRechUtilisateur1Layout.createSequentialGroup()
                        .addGroup(panCorpsRechUtilisateur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsRechUtilisateur1Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panCorpsRechUtilisateur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomUtilisateurRechEtat, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRoleUtilisateurRechEtat, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panCorpsRechUtilisateur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtDebloquerUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(BtBloquerUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel32)
                            .addGroup(panCorpsRechUtilisateur1Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEtatUtilisateurRechEtat, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCorpsRechUtilisateur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsRechUtilisateur1Layout.createSequentialGroup()
                        .addComponent(lblerreurprixarticle11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panCorpsRechUtilisateur1Layout.createSequentialGroup()
                        .addComponent(lblerreurnomarticle16, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jSeparator38, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panCorpsRechUtilisateur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel125)
                            .addComponent(jLabel124))
                        .addContainerGap(34, Short.MAX_VALUE))))
        );
        panCorpsRechUtilisateur1Layout.setVerticalGroup(
            panCorpsRechUtilisateur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsRechUtilisateur1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsRechUtilisateur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtNomUtilisateurRechEtat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtBloquerUtilisateur))
                .addGap(18, 18, 18)
                .addGroup(panCorpsRechUtilisateur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(BtDebloquerUtilisateur)
                    .addComponent(txtRoleUtilisateurRechEtat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panCorpsRechUtilisateur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtEtatUtilisateurRechEtat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMessageMessageUtil1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panCorpsRechUtilisateur1Layout.createSequentialGroup()
                .addGroup(panCorpsRechUtilisateur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsRechUtilisateur1Layout.createSequentialGroup()
                        .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel124)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsRechUtilisateur1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblerreurnomarticle16, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(panCorpsRechUtilisateur1Layout.createSequentialGroup()
                        .addComponent(jSeparator38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lblerreurprixarticle11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblcodearticle43.setText("Choisir Utilisateur");

        cbxRechercherUtilisateurDB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir utilisateur" }));
        cbxRechercherUtilisateurDB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxRechercherUtilisateurDBItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panEtatUtilisateurLayout = new javax.swing.GroupLayout(panEtatUtilisateur);
        panEtatUtilisateur.setLayout(panEtatUtilisateurLayout);
        panEtatUtilisateurLayout.setHorizontalGroup(
            panEtatUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane36)
            .addComponent(panCorpsRechUtilisateur1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panEtatUtilisateurLayout.createSequentialGroup()
                .addComponent(lblcodearticle43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxRechercherUtilisateurDB, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panEtatUtilisateurLayout.setVerticalGroup(
            panEtatUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panEtatUtilisateurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panEtatUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle43, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxRechercherUtilisateurDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panCorpsRechUtilisateur1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        Utilisateur.addTab("Etat", panEtatUtilisateur);

        panListerUtilisateur.setBackground(new java.awt.Color(255, 255, 255));
        panListerUtilisateur.setPreferredSize(new java.awt.Dimension(881, 410));

        panRechEmpl2.setBackground(new java.awt.Color(255, 255, 255));
        panRechEmpl2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Choix de lister utilisateurs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        cbxNomUtilisateurRechercher.setEditable(true);
        cbxNomUtilisateurRechercher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir ou taper nom utilisateur" }));
        cbxNomUtilisateurRechercher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxNomUtilisateurRechercherItemStateChanged(evt);
            }
        });

        btnListerUtilisateur.setText("Lister tout");
        btnListerUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListerUtilisateurActionPerformed(evt);
            }
        });

        cbxEtatUtilisateurRechercher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir etat utilisateur", "Bloque", "Debloque" }));
        cbxEtatUtilisateurRechercher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEtatUtilisateurRechercherItemStateChanged(evt);
            }
        });

        cbxEtatConnexionUtilisateurRechercher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir etat connexion", "Oui", "Non" }));
        cbxEtatConnexionUtilisateurRechercher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEtatConnexionUtilisateurRechercherItemStateChanged(evt);
            }
        });

        cbxroleUtilisateurRechercher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir role utilisateur", "Comptable", "Directeur Achat", "Directeur vente", "Caissier", "Directeur Administratif", "Administrateur" }));
        cbxroleUtilisateurRechercher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxroleUtilisateurRechercherItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panRechEmpl2Layout = new javax.swing.GroupLayout(panRechEmpl2);
        panRechEmpl2.setLayout(panRechEmpl2Layout);
        panRechEmpl2Layout.setHorizontalGroup(
            panRechEmpl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRechEmpl2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxNomUtilisateurRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxEtatUtilisateurRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxEtatConnexionUtilisateurRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxroleUtilisateurRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListerUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panRechEmpl2Layout.setVerticalGroup(
            panRechEmpl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRechEmpl2Layout.createSequentialGroup()
                .addGroup(panRechEmpl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxNomUtilisateurRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEtatUtilisateurRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEtatConnexionUtilisateurRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListerUtilisateur)
                    .addComponent(cbxroleUtilisateurRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        grilleUtilisateur1.setAutoCreateRowSorter(true);
        grilleUtilisateur1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        grilleUtilisateur1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero Utilisateur", "Nom Utilisateur", "Telephone", "Telephone1", "Email", "Email1", "Etat", "Role"
            }
        ));
        jScrollPane40.setViewportView(grilleUtilisateur1);

        grilleUtilisateur2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane15.setViewportView(grilleUtilisateur2);

        javax.swing.GroupLayout panListerUtilisateurLayout = new javax.swing.GroupLayout(panListerUtilisateur);
        panListerUtilisateur.setLayout(panListerUtilisateurLayout);
        panListerUtilisateurLayout.setHorizontalGroup(
            panListerUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15)
            .addGroup(panListerUtilisateurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panListerUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panRechEmpl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE))
                .addContainerGap())
        );
        panListerUtilisateurLayout.setVerticalGroup(
            panListerUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListerUtilisateurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panRechEmpl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane40, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        Utilisateur.addTab("Lister", panListerUtilisateur);

        TbArticle.addTab("Utilisateur", Utilisateur);

        Employe.setBackground(new java.awt.Color(255, 255, 255));
        Employe.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        panEmbaucherEmploye.setBackground(new java.awt.Color(255, 255, 255));

        panCorpsEmploye.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsEmploye.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enregistrement employes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcodearticle14.setText("Matricule");

        lblnomarticle11.setText("Nom");

        txtNomEmploye.setText(" ");

        lblnomarticle12.setText("Prenom");

        lblerreurnomarticle7.setForeground(new java.awt.Color(255, 0, 0));

        jLabel100.setBackground(new java.awt.Color(0, 0, 0));
        jLabel100.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 153, 0));
        jLabel100.setText("Local");
        jLabel100.setToolTipText("");

        jLabel101.setBackground(new java.awt.Color(0, 0, 0));
        jLabel101.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 153, 0));
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("Brico");
        jLabel101.setToolTipText("");
        jLabel101.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator7.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator7.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblnomarticle13.setText("Sexe");

        lblnomarticle14.setText("Adresse");

        cbxSexeEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculin", "Feminin" }));

        lblcodearticle15.setText("Date naissance");

        lblcodearticle16.setText("Date embauche");

        lblcodearticle17.setText("Affectation");

        lblcodearticle18.setText("Fonction");

        lblcodearticle19.setText("Salaire");

        cbxJourEmbaucheEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "jour" }));

        cbxMoisEmbaucheEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "mois", " " }));

        cbxAnneeEmbaucheEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "annee" }));

        cbxAnneeNaisEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "annee" }));

        cbxMoisNaisEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "mois" }));

        cbxJourNaisEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "jour" }));

        cbxAffectationEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Departement Affecte" }));
        cbxAffectationEmploye.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAffectationEmployeItemStateChanged(evt);
            }
        });

        cbxFonctionEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Service de fonctionnement" }));
        cbxFonctionEmploye.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxFonctionEmployeItemStateChanged(evt);
            }
        });

        cbxSalaireEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Salaire alloue" }));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telephones et emails", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(255, 153, 0))); // NOI18N

        lbltelephonefournissuer5.setText("Telephone 1");

        lblemail5.setText("Email 1");

        txEmailEmploye.setText(" ");
        txEmailEmploye.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txEmailEmployeCaretUpdate(evt);
            }
        });
        txEmailEmploye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEmailEmployeActionPerformed(evt);
            }
        });

        lbltelephonefournissuer6.setText("Telephone 2");

        txEmailEmploye1.setText(" ");
        txEmailEmploye1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txEmailEmploye1CaretUpdate(evt);
            }
        });
        txEmailEmploye1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEmailEmploye1ActionPerformed(evt);
            }
        });

        lblemail6.setText("Email 2");

        txtTelephoneEmploye1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelephoneEmploye1CaretUpdate(evt);
            }
        });

        txtTelephoneEmploye.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelephoneEmployeCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelephoneEmploye)
                    .addComponent(txtTelephoneEmploye1)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltelephonefournissuer6)
                            .addComponent(lbltelephonefournissuer5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblemail5)
                    .addComponent(lblemail6)
                    .addComponent(txEmailEmploye, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(txEmailEmploye1))
                .addGap(32, 32, 32))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltelephonefournissuer5)
                    .addComponent(lblemail5))
                .addGap(4, 4, 4)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txEmailEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelephoneEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltelephonefournissuer6)
                    .addComponent(lblemail6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txEmailEmploye1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelephoneEmploye1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        lblMessageEmploye.setText(".");

        btnenregistrerEmploye.setBackground(new java.awt.Color(255, 255, 255));
        btnenregistrerEmploye.setMnemonic('a');
        btnenregistrerEmploye.setText("Ajouter");
        btnenregistrerEmploye.setBorder(null);
        btnenregistrerEmploye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenregistrerEmployeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panCorpsEmployeLayout = new javax.swing.GroupLayout(panCorpsEmploye);
        panCorpsEmploye.setLayout(panCorpsEmployeLayout);
        panCorpsEmployeLayout.setHorizontalGroup(
            panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsEmployeLayout.createSequentialGroup()
                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsEmployeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMessageEmploye, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnenregistrerEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCorpsEmployeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panCorpsEmployeLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsEmployeLayout.createSequentialGroup()
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblnomarticle11)
                                    .addComponent(lblnomarticle12)
                                    .addComponent(lblcodearticle14)
                                    .addComponent(lblnomarticle13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsEmployeLayout.createSequentialGroup()
                                .addComponent(lblnomarticle14)
                                .addGap(22, 22, 22)))
                        .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomEmploye, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txtPrenomEmploye)
                            .addComponent(txtMatriculeEmploye)
                            .addComponent(cbxSexeEmploye, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAdresseEmploye))
                        .addGap(18, 18, 18)
                        .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblcodearticle15)
                            .addComponent(lblcodearticle16)
                            .addComponent(lblcodearticle17)
                            .addComponent(lblcodearticle18)
                            .addComponent(lblcodearticle19))
                        .addGap(6, 6, 6)
                        .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxSalaireEmploye, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxFonctionEmploye, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxAffectationEmploye, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panCorpsEmployeLayout.createSequentialGroup()
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxJourEmbaucheEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxJourNaisEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbxMoisEmbaucheEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxMoisNaisEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxAnneeNaisEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxAnneeEmbaucheEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblerreurnomarticle7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel101)
                    .addComponent(jLabel100))
                .addGap(13, 13, 13))
        );
        panCorpsEmployeLayout.setVerticalGroup(
            panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsEmployeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator7)
                    .addGroup(panCorpsEmployeLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel101)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel100))
                    .addGroup(panCorpsEmployeLayout.createSequentialGroup()
                        .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsEmployeLayout.createSequentialGroup()
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblcodearticle14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMatriculeEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblnomarticle11)
                                    .addComponent(txtNomEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblnomarticle12)
                                    .addComponent(txtPrenomEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblnomarticle13)
                                    .addComponent(cbxSexeEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblnomarticle14)
                                    .addComponent(txtAdresseEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblerreurnomarticle7, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panCorpsEmployeLayout.createSequentialGroup()
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblcodearticle15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxJourNaisEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxMoisNaisEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxAnneeNaisEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblcodearticle16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxJourEmbaucheEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxMoisEmbaucheEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxAnneeEmbaucheEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblcodearticle17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxAffectationEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblcodearticle18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxFonctionEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblcodearticle19, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxSalaireEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCorpsEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnenregistrerEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMessageEmploye))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panEmbaucherEmployeLayout = new javax.swing.GroupLayout(panEmbaucherEmploye);
        panEmbaucherEmploye.setLayout(panEmbaucherEmployeLayout);
        panEmbaucherEmployeLayout.setHorizontalGroup(
            panEmbaucherEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panCorpsEmploye, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panEmbaucherEmployeLayout.setVerticalGroup(
            panEmbaucherEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEmbaucherEmployeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panCorpsEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        Employe.addTab("Enregistrer", panEmbaucherEmploye);

        panModifierEmploye.setBackground(new java.awt.Color(255, 255, 255));

        panCorpsRechEmpl.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsRechEmpl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultats Recherche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcodearticle22.setText("Matricule");

        lblnomarticle15.setText("Nom");

        txNomRechEmploye.setText(" ");

        lblnomarticle16.setText("Prenom");

        lblerreurnomarticle8.setForeground(new java.awt.Color(255, 0, 0));

        lblMessageEmployeModifier.setForeground(new java.awt.Color(0, 0, 255));
        lblMessageEmployeModifier.setText(".");

        jLabel102.setBackground(new java.awt.Color(0, 0, 0));
        jLabel102.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 153, 0));
        jLabel102.setText("Local");
        jLabel102.setToolTipText("");

        jLabel103.setBackground(new java.awt.Color(0, 0, 0));
        jLabel103.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 153, 0));
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setText("Brico");
        jLabel103.setToolTipText("");
        jLabel103.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator10.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator10.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblnomarticle17.setText("Sexe");

        lblnomarticle18.setText("Adresse");

        cbSexeRechEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculin", "Feminin" }));

        lblDateNais.setText("Date naissance");

        lblDateEmbauche.setText("Date embauche");

        lblcodearticle25.setText("Affectation");

        lblcodearticle26.setText("Fonction");

        lblcodearticle27.setText("Salaire");

        cbxJourEmbaucheRechEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jour" }));

        cbxMoisEmbaucheRechEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mois" }));

        cbxAnneeEmbaucheRechEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Annee" }));

        cbxAnneeNaisRechEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Annee" }));

        cbxMoisNaisRechEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mois" }));

        cbxJourNaisRechEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jour" }));

        cbxAffectationRechEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Departement" }));
        cbxAffectationRechEmploye.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAffectationRechEmployeItemStateChanged(evt);
            }
        });

        cbxFonctionRechEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fonction" }));
        cbxFonctionRechEmploye.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxFonctionRechEmployeItemStateChanged(evt);
            }
        });

        cbxSalaireRechEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Salaire" }));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telephones et emails", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(255, 153, 0))); // NOI18N

        lbltelephonefournissuer7.setText("Telephone 1");

        txtEmailRechEmploye.setText(" ");
        txtEmailRechEmploye.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEmailRechEmployeCaretUpdate(evt);
            }
        });
        txtEmailRechEmploye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailRechEmployeActionPerformed(evt);
            }
        });

        lbltelephonefournissuer8.setText("Telephone 2");

        txtEmailRechEmploye1.setText(" ");
        txtEmailRechEmploye1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEmailRechEmploye1CaretUpdate(evt);
            }
        });
        txtEmailRechEmploye1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailRechEmploye1ActionPerformed(evt);
            }
        });

        lblemail8.setText("Email 2");

        txtTelephoneRechEmploye1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelephoneRechEmploye1CaretUpdate(evt);
            }
        });

        txtTelephoneRechEmploye.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelephoneRechEmployeCaretUpdate(evt);
            }
        });

        lblemail7.setText("Email 1");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(lbltelephonefournissuer8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelephoneRechEmploye1))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(lbltelephonefournissuer7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelephoneRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblemail8)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(lblemail7)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmailRechEmploye1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(txtEmailRechEmploye))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltelephonefournissuer7)
                            .addComponent(txtTelephoneRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltelephonefournissuer8)
                            .addComponent(txtTelephoneRechEmploye1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmailRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblemail7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblemail8)
                            .addComponent(txtEmailRechEmploye1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnModifierEmploye.setMnemonic('a');
        btnModifierEmploye.setText("Modifier");
        btnModifierEmploye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierEmployeActionPerformed(evt);
            }
        });

        btnSupprimerEmploye.setMnemonic('a');
        btnSupprimerEmploye.setText("Supprimer");
        btnSupprimerEmploye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerEmployeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panCorpsRechEmplLayout = new javax.swing.GroupLayout(panCorpsRechEmpl);
        panCorpsRechEmpl.setLayout(panCorpsRechEmplLayout);
        panCorpsRechEmplLayout.setHorizontalGroup(
            panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsRechEmplLayout.createSequentialGroup()
                .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsRechEmplLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panCorpsRechEmplLayout.createSequentialGroup()
                                .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblnomarticle15)
                                    .addComponent(lblnomarticle16)
                                    .addComponent(lblcodearticle22)
                                    .addComponent(lblnomarticle17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txNomRechEmploye, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(txtMatriculeRechEmploye)
                                        .addComponent(txPrenomRechEmploye))
                                    .addComponent(cbSexeRechEmploye, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panCorpsRechEmplLayout.createSequentialGroup()
                                .addComponent(lblnomarticle18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txAdresseRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(87, 87, 87)
                        .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateNais)
                            .addComponent(lblDateEmbauche)
                            .addComponent(lblcodearticle25)
                            .addComponent(lblcodearticle26)
                            .addComponent(lblcodearticle27))
                        .addGap(4, 4, 4)
                        .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxSalaireRechEmploye, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxFonctionRechEmploye, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxAffectationRechEmploye, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsRechEmplLayout.createSequentialGroup()
                                .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxJourEmbaucheRechEmploye, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxJourNaisRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbxMoisEmbaucheRechEmploye, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxMoisNaisRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxAnneeNaisRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxAnneeEmbaucheRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblerreurnomarticle8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsRechEmplLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblMessageEmployeModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSupprimerEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModifierEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel103)
                    .addComponent(jLabel102))
                .addGap(13, 13, 13))
        );
        panCorpsRechEmplLayout.setVerticalGroup(
            panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsRechEmplLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator10)
                    .addComponent(lblerreurnomarticle8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panCorpsRechEmplLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCorpsRechEmplLayout.createSequentialGroup()
                        .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblcodearticle22, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMatriculeRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDateNais, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxJourNaisRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxMoisNaisRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxAnneeNaisRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblnomarticle15)
                            .addComponent(txNomRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDateEmbauche, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxJourEmbaucheRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMoisEmbaucheRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxAnneeEmbaucheRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblnomarticle16)
                            .addComponent(txPrenomRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcodearticle25, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxAffectationRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblnomarticle17)
                            .addComponent(cbSexeRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcodearticle26, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxFonctionRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnomarticle18)
                            .addComponent(txAdresseRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblcodearticle27, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxSalaireRechEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsRechEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModifierEmploye)
                            .addComponent(btnSupprimerEmploye)
                            .addComponent(lblMessageEmployeModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbxRechercherEmploye.setEditable(true);
        cbxRechercherEmploye.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir ou saisir numero Employe" }));

        btnRechercherEmp.setText("Rechercher");
        btnRechercherEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercherEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panModifierEmployeLayout = new javax.swing.GroupLayout(panModifierEmploye);
        panModifierEmploye.setLayout(panModifierEmployeLayout);
        panModifierEmployeLayout.setHorizontalGroup(
            panModifierEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panModifierEmployeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panModifierEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panCorpsRechEmpl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panModifierEmployeLayout.createSequentialGroup()
                        .addComponent(cbxRechercherEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRechercherEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(297, Short.MAX_VALUE))))
        );
        panModifierEmployeLayout.setVerticalGroup(
            panModifierEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panModifierEmployeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panModifierEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxRechercherEmploye)
                    .addComponent(btnRechercherEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCorpsRechEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        Employe.addTab("Modifier", panModifierEmploye);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        grilleRechEmploye.setAutoCreateRowSorter(true);
        grilleRechEmploye.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "numero", "nif", "Nom", "Prenom", "Sexe", "Adresse", "Telephone", "Telphone1", "Email", "Email1", "date naissance", "dateembauche", "departement affecte", "Fonction", "Salaire"
            }
        ));
        jScrollPane31.setViewportView(grilleRechEmploye);

        lblcodearticle20.setText("Taper indice de reherche");
        lblcodearticle20.setToolTipText("Entrer numero ou nom ou prenom ou telephone ou fonction de l'employe");

        txtRechercherEmployerIndice.setName("txtLibelleProduit"); // NOI18N
        txtRechercherEmployerIndice.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtRechercherEmployerIndiceCaretUpdate(evt);
            }
        });
        txtRechercherEmployerIndice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRechercherEmployerIndiceActionPerformed(evt);
            }
        });
        txtRechercherEmployerIndice.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtRechercherEmployerIndicePropertyChange(evt);
            }
        });

        btnAfficherEmploye.setBackground(new java.awt.Color(255, 255, 255));
        btnAfficherEmploye.setText("Afficher");
        btnAfficherEmploye.setBorder(javax.swing.BorderFactory.createTitledBorder("Afficher tout"));
        btnAfficherEmploye.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAfficherEmployeMouseMoved(evt);
            }
        });
        btnAfficherEmploye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfficherEmployeActionPerformed(evt);
            }
        });

        lblTotalEmploye.setText("jLabel7");
        lblTotalEmploye.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre total d'employes"));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTotalEmploye, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane31, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblcodearticle20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRechercherEmployerIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAfficherEmploye, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAfficherEmploye, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRechercherEmployerIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalEmploye, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(166, 166, 166))
        );

        Employe.addTab("Rechercher", jPanel11);

        TbArticle.addTab("Employe", Employe);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        Fournisseur.setBackground(new java.awt.Color(255, 255, 255));
        Fournisseur.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        panAjouterFournisseur1.setBackground(new java.awt.Color(255, 255, 255));

        panCorpsFournisseur.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsFournisseur.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enregistrement fournisseurs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblMessageFournisseur.setForeground(new java.awt.Color(255, 0, 0));

        jLabel96.setBackground(new java.awt.Color(0, 0, 0));
        jLabel96.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 153, 0));
        jLabel96.setText("Local");
        jLabel96.setToolTipText("");

        jLabel97.setBackground(new java.awt.Color(0, 0, 0));
        jLabel97.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 153, 0));
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("Brico");
        jLabel97.setToolTipText("");
        jLabel97.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator4.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator4.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Autres , telephones et emails", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        lbltelephonefournissuer.setText("Telephone 1");

        lblemail.setText("Email 1");

        txEmailFournisseur1.setText(" ");
        txEmailFournisseur1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEmailFournisseur1ActionPerformed(evt);
            }
        });

        lbltelephonefournissuer3.setText("Telephone 2");

        txEmailFournisseur2.setText(" ");
        txEmailFournisseur2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEmailFournisseur2ActionPerformed(evt);
            }
        });

        lblemail3.setText("Email 2");

        txtTelephoneFourni2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelephoneFourni2CaretUpdate(evt);
            }
        });

        txTelephoneFournisseur1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txTelephoneFournisseur1CaretUpdate(evt);
            }
        });

        lblcodearticle10.setText("Nom");

        lblnomarticle7.setText("Telephone");

        txTelephoneFournisseur.setText(" ");
        txTelephoneFournisseur.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txTelephoneFournisseurCaretUpdate(evt);
            }
        });

        txtEmaillFournisseur.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEmaillFournisseurCaretUpdate(evt);
            }
        });

        lblnomarticle8.setText("Email");

        lblnomarticle23.setText("Adresse");

        panAjouterFournisseur.setBackground(new java.awt.Color(255, 255, 255));
        panAjouterFournisseur.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnajouterFournisseur.setMnemonic('a');
        btnajouterFournisseur.setText("Ajouter");
        btnajouterFournisseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnajouterFournisseurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAjouterFournisseurLayout = new javax.swing.GroupLayout(panAjouterFournisseur);
        panAjouterFournisseur.setLayout(panAjouterFournisseurLayout);
        panAjouterFournisseurLayout.setHorizontalGroup(
            panAjouterFournisseurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAjouterFournisseurLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnajouterFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panAjouterFournisseurLayout.setVerticalGroup(
            panAjouterFournisseurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAjouterFournisseurLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnajouterFournisseur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(lblnomarticle23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAdresselFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnomarticle7)
                            .addComponent(lblnomarticle8)
                            .addComponent(lblcodearticle10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txTelephoneFournisseur)
                            .addComponent(txtEmaillFournisseur)
                            .addComponent(txtNomFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbltelephonefournissuer3)
                            .addComponent(txtTelephoneFourni2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(txEmailFournisseur2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltelephonefournissuer)
                            .addComponent(txTelephoneFournisseur1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblemail)
                            .addComponent(lblemail3)
                            .addComponent(txEmailFournisseur1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panAjouterFournisseur, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcodearticle10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblnomarticle7)
                            .addComponent(txTelephoneFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblnomarticle8)
                            .addComponent(txtEmaillFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltelephonefournissuer)
                            .addComponent(lblemail))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txEmailFournisseur1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txTelephoneFournisseur1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltelephonefournissuer3)
                            .addComponent(lblemail3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txEmailFournisseur2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelephoneFourni2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAdresselFournisseur)
                    .addComponent(lblnomarticle23)
                    .addComponent(panAjouterFournisseur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panCorpsFournisseurLayout = new javax.swing.GroupLayout(panCorpsFournisseur);
        panCorpsFournisseur.setLayout(panCorpsFournisseurLayout);
        panCorpsFournisseurLayout.setHorizontalGroup(
            panCorpsFournisseurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsFournisseurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsFournisseurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsFournisseurLayout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 102, Short.MAX_VALUE))
                    .addComponent(lblMessageFournisseur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(panCorpsFournisseurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel97, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel96, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panCorpsFournisseurLayout.setVerticalGroup(
            panCorpsFournisseurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsFournisseurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsFournisseurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panCorpsFournisseurLayout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMessageFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCorpsFournisseurLayout.createSequentialGroup()
                        .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panAjouterFournisseur1Layout = new javax.swing.GroupLayout(panAjouterFournisseur1);
        panAjouterFournisseur1.setLayout(panAjouterFournisseur1Layout);
        panAjouterFournisseur1Layout.setHorizontalGroup(
            panAjouterFournisseur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panCorpsFournisseur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panAjouterFournisseur1Layout.setVerticalGroup(
            panAjouterFournisseur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAjouterFournisseur1Layout.createSequentialGroup()
                .addComponent(panCorpsFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 92, Short.MAX_VALUE))
        );

        Fournisseur.addTab("Ajouter", panAjouterFournisseur1);

        panRecherchercherFournisseur.setBackground(new java.awt.Color(255, 255, 255));

        jPanel79.setBackground(new java.awt.Color(255, 255, 255));
        jPanel79.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recherche fournisseur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcodearticle11.setText("Choisir nom fournisseur ");

        cbxRechercherNomFournisseur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selectionner nom fournisseur" }));
        cbxRechercherNomFournisseur.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxRechercherNomFournisseurItemStateChanged(evt);
            }
        });

        lblcodearticle12.setText("Choisir numero fournisseur");

        cbxRechercherNumeroFournisseur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selectionner numero fournisseur" }));
        cbxRechercherNumeroFournisseur.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxRechercherNumeroFournisseurItemStateChanged(evt);
            }
        });
        cbxRechercherNumeroFournisseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRechercherNumeroFournisseurActionPerformed(evt);
            }
        });

        jtChargerFournisseur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jtChargerFournisseur);

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle11)
                    .addComponent(cbxRechercherNomFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblcodearticle12, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(cbxRechercherNumeroFournisseur, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addComponent(lblcodearticle11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxRechercherNomFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxRechercherNumeroFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(lblcodearticle12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panCorpsFournisseur1.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsFournisseur1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enregistrement fournisseur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblerreurnomarticle6.setForeground(new java.awt.Color(255, 0, 0));

        jLabel98.setBackground(new java.awt.Color(0, 0, 0));
        jLabel98.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 153, 0));
        jLabel98.setText("Local");
        jLabel98.setToolTipText("");

        jLabel99.setBackground(new java.awt.Color(0, 0, 0));
        jLabel99.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 153, 0));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("Brico");
        jLabel99.setToolTipText("");
        jLabel99.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator6.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator6.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Autres telephones et emails", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(255, 153, 0))); // NOI18N

        lbltelephonefournissuer1.setText("Telephone 1");

        lblemail1.setText("Email 1");

        txEmailFournisseur4.setText(" ");
        txEmailFournisseur4.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txEmailFournisseur4CaretUpdate(evt);
            }
        });
        txEmailFournisseur4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEmailFournisseur4ActionPerformed(evt);
            }
        });

        lbltelephonefournissuer4.setText("Telephone 2");

        txEmailFournisseur5.setText(" ");
        txEmailFournisseur5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEmailFournisseur5ActionPerformed(evt);
            }
        });

        lblemail4.setText("Email 2");

        txtTelephoneRechFourni1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelephoneRechFourni1CaretUpdate(evt);
            }
        });

        txtTelephoneRechFourni2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelephoneRechFourni2CaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(lbltelephonefournissuer4)
                                .addGap(50, 50, 50))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(txtTelephoneRechFourni2)
                                .addGap(10, 10, 10)))
                        .addComponent(txEmailFournisseur5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltelephonefournissuer1)
                            .addComponent(txtTelephoneRechFourni1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblemail1)
                            .addComponent(lblemail4)
                            .addComponent(txEmailFournisseur4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltelephonefournissuer1)
                    .addComponent(lblemail1))
                .addGap(3, 3, 3)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txEmailFournisseur4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelephoneRechFourni1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltelephonefournissuer4)
                    .addComponent(lblemail4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txEmailFournisseur5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelephoneRechFourni2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panAjouterFournisseur2.setBackground(new java.awt.Color(255, 255, 255));
        panAjouterFournisseur2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnSupprimerFournisseur.setMnemonic('a');
        btnSupprimerFournisseur.setText("Supprimer");
        btnSupprimerFournisseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerFournisseurActionPerformed(evt);
            }
        });

        btModifierFournisseur.setText("Modifier");
        btModifierFournisseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModifierFournisseurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAjouterFournisseur2Layout = new javax.swing.GroupLayout(panAjouterFournisseur2);
        panAjouterFournisseur2.setLayout(panAjouterFournisseur2Layout);
        panAjouterFournisseur2Layout.setHorizontalGroup(
            panAjouterFournisseur2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAjouterFournisseur2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSupprimerFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btModifierFournisseur, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );
        panAjouterFournisseur2Layout.setVerticalGroup(
            panAjouterFournisseur2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAjouterFournisseur2Layout.createSequentialGroup()
                .addGroup(panAjouterFournisseur2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSupprimerFournisseur)
                    .addComponent(btModifierFournisseur))
                .addGap(0, 49, Short.MAX_VALUE))
        );

        panFourniss.setBackground(new java.awt.Color(255, 255, 255));

        lblcodearticle13.setText("Nom");

        txTelephoneFournisseur2.setText(" ");
        txTelephoneFournisseur2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txTelephoneFournisseur2CaretUpdate(evt);
            }
        });

        lblnomarticle9.setText("Telephone");

        txEmailFournisseur3.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txEmailFournisseur3CaretUpdate(evt);
            }
        });

        lblnomarticle10.setText("Email");

        txAdresseFournisseur1.setBorder(javax.swing.BorderFactory.createTitledBorder("Adresse"));
        jScrollPane28.setViewportView(txAdresseFournisseur1);

        javax.swing.GroupLayout panFournissLayout = new javax.swing.GroupLayout(panFourniss);
        panFourniss.setLayout(panFournissLayout);
        panFournissLayout.setHorizontalGroup(
            panFournissLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFournissLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFournissLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txEmailFournisseur3)
                    .addComponent(txTelephoneFournisseur2)
                    .addGroup(panFournissLayout.createSequentialGroup()
                        .addGroup(panFournissLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblcodearticle13)
                            .addComponent(txtNomFournisseur1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnomarticle10)
                            .addComponent(lblnomarticle9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane28))
                .addContainerGap())
        );
        panFournissLayout.setVerticalGroup(
            panFournissLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFournissLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblcodearticle13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNomFournisseur1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblnomarticle10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txEmailFournisseur3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnomarticle9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txTelephoneFournisseur2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblMessageModifierFournisseur.setText("|");

        javax.swing.GroupLayout panCorpsFournisseur1Layout = new javax.swing.GroupLayout(panCorpsFournisseur1);
        panCorpsFournisseur1.setLayout(panCorpsFournisseur1Layout);
        panCorpsFournisseur1Layout.setHorizontalGroup(
            panCorpsFournisseur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsFournisseur1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panFourniss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(panCorpsFournisseur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panCorpsFournisseur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMessageModifierFournisseur)
                        .addComponent(panAjouterFournisseur2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(lblerreurnomarticle6, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panCorpsFournisseur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99)
                    .addComponent(jLabel98))
                .addGap(16, 16, 16))
        );
        panCorpsFournisseur1Layout.setVerticalGroup(
            panCorpsFournisseur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsFournisseur1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsFournisseur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsFournisseur1Layout.createSequentialGroup()
                        .addComponent(panFourniss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(78, 78, 78))
                    .addGroup(panCorpsFournisseur1Layout.createSequentialGroup()
                        .addGroup(panCorpsFournisseur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblerreurnomarticle6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panCorpsFournisseur1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panCorpsFournisseur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panCorpsFournisseur1Layout.createSequentialGroup()
                                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panAjouterFournisseur2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblMessageModifierFournisseur))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout panRecherchercherFournisseurLayout = new javax.swing.GroupLayout(panRecherchercherFournisseur);
        panRecherchercherFournisseur.setLayout(panRecherchercherFournisseurLayout);
        panRecherchercherFournisseurLayout.setHorizontalGroup(
            panRecherchercherFournisseurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panCorpsFournisseur1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panRecherchercherFournisseurLayout.setVerticalGroup(
            panRecherchercherFournisseurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRecherchercherFournisseurLayout.createSequentialGroup()
                .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCorpsFournisseur1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Fournisseur.addTab("Rechercher", panRecherchercherFournisseur);

        PanListerFournisseur.setBackground(new java.awt.Color(255, 255, 255));

        grilleFournisseur2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 153, 0), null, java.awt.Color.orange));
        grilleFournisseur2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Adresse", "Telephone", "Telephone1", "Telephone2", "Email", "Email1", "Email2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane30.setViewportView(grilleFournisseur2);

        javax.swing.GroupLayout PanListerFournisseurLayout = new javax.swing.GroupLayout(PanListerFournisseur);
        PanListerFournisseur.setLayout(PanListerFournisseurLayout);
        PanListerFournisseurLayout.setHorizontalGroup(
            PanListerFournisseurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
        );
        PanListerFournisseurLayout.setVerticalGroup(
            PanListerFournisseurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanListerFournisseurLayout.createSequentialGroup()
                .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 102, Short.MAX_VALUE))
        );

        Fournisseur.addTab("Afficher", PanListerFournisseur);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 938, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Fournisseur))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Fournisseur)
                    .addContainerGap()))
        );

        TbArticle.addTab("Fournisseur", jPanel6);

        Categorie.setBackground(new java.awt.Color(255, 255, 255));
        Categorie.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel3.setFocusTraversalPolicyProvider(true);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        panCorpsAjouterProduit3.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsAjouterProduit3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ajout de categorie", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblerreurnomarticle3.setForeground(new java.awt.Color(255, 0, 0));

        txtCategorie.setBorder(javax.swing.BorderFactory.createTitledBorder("Taper nouvelle categorie"));
        jScrollPane22.setViewportView(txtCategorie);

        btAjouterCategorie.setBackground(new java.awt.Color(204, 204, 204));
        btAjouterCategorie.setText("Ajouter");
        btAjouterCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjouterCategorieActionPerformed(evt);
            }
        });

        jLabel92.setBackground(new java.awt.Color(0, 0, 0));
        jLabel92.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 153, 0));
        jLabel92.setText("Local");
        jLabel92.setToolTipText("");

        jLabel93.setBackground(new java.awt.Color(0, 0, 0));
        jLabel93.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 153, 0));
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Brico");
        jLabel93.setToolTipText("");
        jLabel93.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator9.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator9.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        LblMessageCategorie.setText("|");

        javax.swing.GroupLayout panCorpsAjouterProduit3Layout = new javax.swing.GroupLayout(panCorpsAjouterProduit3);
        panCorpsAjouterProduit3.setLayout(panCorpsAjouterProduit3Layout);
        panCorpsAjouterProduit3Layout.setHorizontalGroup(
            panCorpsAjouterProduit3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsAjouterProduit3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsAjouterProduit3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsAjouterProduit3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                        .addComponent(LblMessageCategorie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btAjouterCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(lblerreurnomarticle3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panCorpsAjouterProduit3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel93)
                    .addComponent(jLabel92))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panCorpsAjouterProduit3Layout.setVerticalGroup(
            panCorpsAjouterProduit3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsAjouterProduit3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsAjouterProduit3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsAjouterProduit3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panCorpsAjouterProduit3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsAjouterProduit3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblerreurnomarticle3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(panCorpsAjouterProduit3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(22, 22, 22))))
                    .addGroup(panCorpsAjouterProduit3Layout.createSequentialGroup()
                        .addComponent(jSeparator9)
                        .addGap(22, 22, 22))
                    .addGroup(panCorpsAjouterProduit3Layout.createSequentialGroup()
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAjouterCategorie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblMessageCategorie)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(panCorpsAjouterProduit3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(panCorpsAjouterProduit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 183, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Categorie.addTab("Ajouter", jPanel3);

        panRechercherCategorie.setBackground(new java.awt.Color(255, 255, 255));

        panCorpsCategorie.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsCategorie.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultat recherche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblerreurnomarticle4.setForeground(new java.awt.Color(255, 0, 0));

        lblerreurprixarticle4.setForeground(new java.awt.Color(255, 0, 0));

        txtCategorieRechercher.setBorder(javax.swing.BorderFactory.createTitledBorder("Taper nouvelle categorie"));
        jScrollPane24.setViewportView(txtCategorieRechercher);

        jLabel94.setBackground(new java.awt.Color(0, 0, 0));
        jLabel94.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 153, 0));
        jLabel94.setText("Local");
        jLabel94.setToolTipText("");

        jLabel95.setBackground(new java.awt.Color(0, 0, 0));
        jLabel95.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 153, 0));
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("Brico");
        jLabel95.setToolTipText("");
        jLabel95.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator26.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator26.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator26.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btSupprimerCategorie.setText("Supprimer");
        btSupprimerCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSupprimerCategorieActionPerformed(evt);
            }
        });

        btModifierCategorie.setText("Modifier");
        btModifierCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModifierCategorieActionPerformed(evt);
            }
        });

        jLabel17.setText("Numero");

        txtNumeroCategorieRechercher.setEditable(false);

        javax.swing.GroupLayout panCorpsCategorieLayout = new javax.swing.GroupLayout(panCorpsCategorie);
        panCorpsCategorie.setLayout(panCorpsCategorieLayout);
        panCorpsCategorieLayout.setHorizontalGroup(
            panCorpsCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsCategorieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panCorpsCategorieLayout.createSequentialGroup()
                        .addComponent(btSupprimerCategorie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btModifierCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCorpsCategorieLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumeroCategorieRechercher))
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panCorpsCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsCategorieLayout.createSequentialGroup()
                        .addComponent(lblerreurprixarticle4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panCorpsCategorieLayout.createSequentialGroup()
                        .addComponent(lblerreurnomarticle4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panCorpsCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel95)
                            .addComponent(jLabel94))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panCorpsCategorieLayout.setVerticalGroup(
            panCorpsCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsCategorieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsCategorieLayout.createSequentialGroup()
                        .addGroup(panCorpsCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroCategorieRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panCorpsCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSupprimerCategorie)
                            .addComponent(btModifierCategorie))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panCorpsCategorieLayout.createSequentialGroup()
                        .addGroup(panCorpsCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsCategorieLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panCorpsCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCorpsCategorieLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblerreurnomarticle4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46))
                                    .addGroup(panCorpsCategorieLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsCategorieLayout.createSequentialGroup()
                                .addComponent(jSeparator26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(lblerreurprixarticle4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jtListerCategorie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 153, 0), null, java.awt.Color.orange));
        jtListerCategorie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numero categorie", "Description", "Date ajout"
            }
        ));
        jScrollPane25.setViewportView(jtListerCategorie);

        cbRechercherDescCategorie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRechercherDescCategorie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRechercherDescCategorieItemStateChanged(evt);
            }
        });

        lblcodearticle3.setText("Choisir categorie voulu rechercher ");

        lblcodearticle9.setText("Choisir la date ajout categorie  voulu rechercher ");

        cbRechercherDateAjoutCAtegorie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRechercherDateAjoutCAtegorie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRechercherDateAjoutCAtegorieItemStateChanged(evt);
            }
        });

        jtChargerCategorie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(jtChargerCategorie);

        javax.swing.GroupLayout panRechercherCategorieLayout = new javax.swing.GroupLayout(panRechercherCategorie);
        panRechercherCategorie.setLayout(panRechercherCategorieLayout);
        panRechercherCategorieLayout.setHorizontalGroup(
            panRechercherCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane25)
            .addGroup(panRechercherCategorieLayout.createSequentialGroup()
                .addGroup(panRechercherCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panRechercherCategorieLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panRechercherCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblcodearticle3)
                            .addComponent(cbRechercherDescCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panRechercherCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblcodearticle9, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRechercherDateAjoutCAtegorie, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panCorpsCategorie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panRechercherCategorieLayout.setVerticalGroup(
            panRechercherCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRechercherCategorieLayout.createSequentialGroup()
                .addGroup(panRechercherCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panRechercherCategorieLayout.createSequentialGroup()
                        .addComponent(lblcodearticle3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panRechercherCategorieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbRechercherDescCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRechercherDateAjoutCAtegorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblcodearticle9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCorpsCategorie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panRechercherCategorie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panRechercherCategorie, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
        );

        Categorie.addTab("Rechercher", jPanel5);

        TbArticle.addTab("Categorie", Categorie);

        Achat.setBackground(new java.awt.Color(255, 255, 255));
        Achat.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        panCorpsAchat.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsAchat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enregistrement achats", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcodearticle28.setText("Description");

        lblnomarticle19.setText("Quantite");

        txtQuantiteAchat.setText(" ");

        lblnomarticle20.setText("Prix");

        lblerreurnomarticle10.setForeground(new java.awt.Color(255, 0, 0));

        txtPrixAchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrixAchatActionPerformed(evt);
            }
        });

        jLabel106.setBackground(new java.awt.Color(0, 0, 0));
        jLabel106.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 153, 0));
        jLabel106.setText("Local");
        jLabel106.setToolTipText("");

        jLabel107.setBackground(new java.awt.Color(0, 0, 0));
        jLabel107.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 153, 0));
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("Brico");
        jLabel107.setToolTipText("");
        jLabel107.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator28.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator28.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator28.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblnomarticle21.setText("Frais");

        lblnomarticle22.setText("Fournisseur");

        cbFournisseurAchat.setEditable(true);
        cbFournisseurAchat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFournisseurAchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFournisseurAchatActionPerformed(evt);
            }
        });

        btnenregistrerAchat.setMnemonic('a');
        btnenregistrerAchat.setText("Ajouter");
        btnenregistrerAchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenregistrerAchatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panCorpsAchatLayout = new javax.swing.GroupLayout(panCorpsAchat);
        panCorpsAchat.setLayout(panCorpsAchatLayout);
        panCorpsAchatLayout.setHorizontalGroup(
            panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsAchatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnomarticle20)
                    .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txDescriptionAchat, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtQuantiteAchat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                    .addComponent(lblcodearticle28)
                    .addComponent(lblnomarticle19)
                    .addComponent(txtPrixAchat, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsAchatLayout.createSequentialGroup()
                        .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panCorpsAchatLayout.createSequentialGroup()
                                .addComponent(lblnomarticle22)
                                .addGap(158, 158, 158))
                            .addComponent(lblnomarticle21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblerreurnomarticle10, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                    .addGroup(panCorpsAchatLayout.createSequentialGroup()
                        .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbFournisseurAchat, 0, 188, Short.MAX_VALUE)
                            .addComponent(txFraisAchat)
                            .addComponent(btnenregistrerAchat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel107)
                    .addComponent(jLabel106))
                .addGap(13, 13, 13))
        );
        panCorpsAchatLayout.setVerticalGroup(
            panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsAchatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsAchatLayout.createSequentialGroup()
                        .addComponent(jSeparator28)
                        .addGap(22, 22, 22))
                    .addGroup(panCorpsAchatLayout.createSequentialGroup()
                        .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsAchatLayout.createSequentialGroup()
                                .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCorpsAchatLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lblerreurnomarticle10, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panCorpsAchatLayout.createSequentialGroup()
                                        .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblcodearticle28, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblnomarticle22))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txDescriptionAchat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbFournisseurAchat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCorpsAchatLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblnomarticle19)
                                        .addGap(11, 11, 11)
                                        .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtQuantiteAchat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txFraisAchat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblnomarticle20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panCorpsAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPrixAchat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnenregistrerAchat)))
                                    .addGroup(panCorpsAchatLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(lblnomarticle21))))
                            .addGroup(panCorpsAchatLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(214, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout panEnregistrerAchatLayout = new javax.swing.GroupLayout(panEnregistrerAchat);
        panEnregistrerAchat.setLayout(panEnregistrerAchatLayout);
        panEnregistrerAchatLayout.setHorizontalGroup(
            panEnregistrerAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panCorpsAchat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panEnregistrerAchatLayout.setVerticalGroup(
            panEnregistrerAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEnregistrerAchatLayout.createSequentialGroup()
                .addComponent(panCorpsAchat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Achat.addTab("Enregistrer", panEnregistrerAchat);

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recherche d'articles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcodearticle29.setText("Choisir achat ");

        cbRechercherDescriptionAchat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblcodearticle30.setText("Choisir la date enregistrement achat  voulu rechercher ");

        cbRechercherDateAjoutAchat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle29)
                    .addComponent(cbRechercherDescriptionAchat, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle30, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRechercherDateAjoutAchat, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(295, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(lblcodearticle29, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbRechercherDescriptionAchat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRechercherDateAjoutAchat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblcodearticle30, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panCorpsAchatRech.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsAchatRech.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enregistrement achats", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcodearticle32.setText("Description");

        lblnomarticle27.setText("Quantite");

        txtQuantiteAchatRech.setText(" ");

        lblnomarticle28.setText("Prix");

        lblerreurnomarticle12.setForeground(new java.awt.Color(255, 0, 0));

        txtPrixAchatRech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrixAchatRechActionPerformed(evt);
            }
        });

        jLabel110.setBackground(new java.awt.Color(0, 0, 0));
        jLabel110.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 153, 0));
        jLabel110.setText("Local");
        jLabel110.setToolTipText("");

        jLabel111.setBackground(new java.awt.Color(0, 0, 0));
        jLabel111.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 153, 0));
        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel111.setText("Brico");
        jLabel111.setToolTipText("");
        jLabel111.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator31.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator31.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator31.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblnomarticle29.setText("Frais");

        lblnomarticle30.setText("Fournisseur");

        cbFournisseurARech.setEditable(true);
        cbFournisseurARech.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFournisseurARech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFournisseurARechActionPerformed(evt);
            }
        });

        btnModifierAchat.setMnemonic('a');
        btnModifierAchat.setText("Modifier");
        btnModifierAchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierAchatActionPerformed(evt);
            }
        });

        btnSupprimerAchat.setMnemonic('a');
        btnSupprimerAchat.setText("Supprimer");
        btnSupprimerAchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerAchatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panCorpsAchatRechLayout = new javax.swing.GroupLayout(panCorpsAchatRech);
        panCorpsAchatRech.setLayout(panCorpsAchatRechLayout);
        panCorpsAchatRechLayout.setHorizontalGroup(
            panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnomarticle28)
                    .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txDescriptionAchatRech, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtQuantiteAchatRech, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                    .addComponent(lblcodearticle32)
                    .addComponent(lblnomarticle27)
                    .addComponent(txtPrixAchatRech, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                        .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                                .addComponent(lblnomarticle30)
                                .addGap(158, 158, 158))
                            .addComponent(lblnomarticle29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblerreurnomarticle12, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                    .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                        .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbFournisseurARech, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txFraisAchatRech)
                            .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                                .addComponent(btnModifierAchat, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSupprimerAchat, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel111)
                    .addComponent(jLabel110))
                .addGap(13, 13, 13))
        );
        panCorpsAchatRechLayout.setVerticalGroup(
            panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                        .addComponent(jSeparator31)
                        .addGap(22, 22, 22))
                    .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                        .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                                .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lblerreurnomarticle12, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                                        .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblcodearticle32, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblnomarticle30))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txDescriptionAchatRech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbFournisseurARech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblnomarticle27)
                                        .addGap(11, 11, 11)
                                        .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtQuantiteAchatRech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txFraisAchatRech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblnomarticle28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panCorpsAchatRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPrixAchatRech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnModifierAchat)
                                            .addComponent(btnSupprimerAchat)))
                                    .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(lblnomarticle29))))
                            .addGroup(panCorpsAchatRechLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        grilleAchat1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane32.setViewportView(grilleAchat1);

        javax.swing.GroupLayout panRechercherAchatLayout = new javax.swing.GroupLayout(panRechercherAchat);
        panRechercherAchat.setLayout(panRechercherAchatLayout);
        panRechercherAchatLayout.setHorizontalGroup(
            panRechercherAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panCorpsAchatRech, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRechercherAchatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane32, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                .addContainerGap())
        );
        panRechercherAchatLayout.setVerticalGroup(
            panRechercherAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRechercherAchatLayout.createSequentialGroup()
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCorpsAchatRech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        Achat.addTab("Rechercher", panRechercherAchat);

        TbArticle.addTab("Achat", Achat);

        Article.setBackground(new java.awt.Color(255, 255, 255));

        TbAjouterArticle.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        panArticle.setBackground(new java.awt.Color(255, 255, 255));

        panAjouterArtcile.setBackground(new java.awt.Color(255, 255, 255));

        panCorpsAjouterProduit.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsAjouterProduit.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enregistrement d'articles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcategorie.setText("Categorie");

        lblcodearticle.setText("Fournisseur");

        lblnomarticle.setText("Quantite");

        lblnomarticle1.setText("Prix Article");

        lblerreurnomarticle.setForeground(new java.awt.Color(255, 0, 0));

        cbFournisseurAjouterArticle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFournisseurAjouterArticle.setToolTipText("Selectionner le fournisseur");
        cbFournisseurAjouterArticle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFournisseurAjouterArticleItemStateChanged(evt);
            }
        });

        txtDescriptionArticle.setBorder(javax.swing.BorderFactory.createTitledBorder("Description"));
        jScrollPane16.setViewportView(txtDescriptionArticle);

        BtAjouterArticle.setBackground(new java.awt.Color(204, 204, 204));
        BtAjouterArticle.setText("Ajouter");
        BtAjouterArticle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtAjouterArticleMouseClicked(evt);
            }
        });
        BtAjouterArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjouterArticleActionPerformed(evt);
            }
        });

        jLabel86.setBackground(new java.awt.Color(0, 0, 0));
        jLabel86.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 153, 0));
        jLabel86.setText("Local");
        jLabel86.setToolTipText("");

        jLabel87.setBackground(new java.awt.Color(0, 0, 0));
        jLabel87.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 153, 0));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("Brico");
        jLabel87.setToolTipText("");
        jLabel87.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator3.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator3.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panCorpsAjouterProduitLayout = new javax.swing.GroupLayout(panCorpsAjouterProduit);
        panCorpsAjouterProduit.setLayout(panCorpsAjouterProduitLayout);
        panCorpsAjouterProduitLayout.setHorizontalGroup(
            panCorpsAjouterProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsAjouterProduitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsAjouterProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panCorpsAjouterProduitLayout.createSequentialGroup()
                        .addComponent(lblcodearticle)
                        .addGap(18, 18, 18)
                        .addGroup(panCorpsAjouterProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CbCategorieAjouterArticle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbFournisseurAjouterArticle, 0, 170, Short.MAX_VALUE)))
                    .addComponent(lblcategorie)
                    .addComponent(jScrollPane16))
                .addGap(18, 18, 18)
                .addGroup(panCorpsAjouterProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrixArticle, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(lblnomarticle)
                    .addComponent(lblnomarticle1)
                    .addComponent(txtQuantiteArticle)
                    .addComponent(BtAjouterArticle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblerreurnomarticle, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panCorpsAjouterProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel87)
                    .addComponent(jLabel86))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panCorpsAjouterProduitLayout.setVerticalGroup(
            panCorpsAjouterProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsAjouterProduitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsAjouterProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsAjouterProduitLayout.createSequentialGroup()
                        .addGroup(panCorpsAjouterProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcodearticle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFournisseurAjouterArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnomarticle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsAjouterProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcategorie)
                            .addComponent(CbCategorieAjouterArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantiteArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsAjouterProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panCorpsAjouterProduitLayout.createSequentialGroup()
                                .addComponent(lblnomarticle1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrixArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtAjouterArticle))
                            .addComponent(jScrollPane16))
                        .addContainerGap())
                    .addGroup(panCorpsAjouterProduitLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panCorpsAjouterProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsAjouterProduitLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblerreurnomarticle, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(panCorpsAjouterProduitLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(22, 22, 22))))
                    .addGroup(panCorpsAjouterProduitLayout.createSequentialGroup()
                        .addComponent(jSeparator3)
                        .addGap(22, 22, 22))))
        );

        javax.swing.GroupLayout panAjouterArtcileLayout = new javax.swing.GroupLayout(panAjouterArtcile);
        panAjouterArtcile.setLayout(panAjouterArtcileLayout);
        panAjouterArtcileLayout.setHorizontalGroup(
            panAjouterArtcileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAjouterArtcileLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(panCorpsAjouterProduit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panAjouterArtcileLayout.setVerticalGroup(
            panAjouterArtcileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAjouterArtcileLayout.createSequentialGroup()
                .addComponent(panCorpsAjouterProduit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(131, 131, 131))
        );

        javax.swing.GroupLayout panArticleLayout = new javax.swing.GroupLayout(panArticle);
        panArticle.setLayout(panArticleLayout);
        panArticleLayout.setHorizontalGroup(
            panArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panArticleLayout.createSequentialGroup()
                .addComponent(panAjouterArtcile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panArticleLayout.setVerticalGroup(
            panArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panArticleLayout.createSequentialGroup()
                .addComponent(panAjouterArtcile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TbAjouterArticle.addTab("AJouter", panArticle);

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recherche d'articles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcodearticle1.setText("Choisir description article voulu rechercher ");

        cbRechercherDescription.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRechercherDescription.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRechercherDescriptionItemStateChanged(evt);
            }
        });

        lblcodearticle4.setText("Choisir la date ajout article voulu rechercher ");

        cbRechercherDateAjout.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRechercherDateAjout.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRechercherDateAjoutItemStateChanged(evt);
            }
        });

        jtChargerArticle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane3.setViewportView(jtChargerArticle);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle1)
                    .addComponent(cbRechercherDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle4, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRechercherDateAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(lblcodearticle1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbRechercherDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbRechercherDateAjout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblcodearticle4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        tbArticleRechercher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero article", "Description", "Categorie", "Prix unitaire", "Qte en stock", "Date ajout", "Fournisseur", "Utilisateur"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbArticleRechercher.setToolTipText("");
        jScrollPane19.setViewportView(tbArticleRechercher);

        javax.swing.GroupLayout panRechercherArticleLayout = new javax.swing.GroupLayout(panRechercherArticle);
        panRechercherArticle.setLayout(panRechercherArticleLayout);
        panRechercherArticleLayout.setHorizontalGroup(
            panRechercherArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane19)
        );
        panRechercherArticleLayout.setVerticalGroup(
            panRechercherArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRechercherArticleLayout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panRechercherArticle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panRechercherArticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TbAjouterArticle.addTab("Rechercher", jPanel1);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel76.setBackground(new java.awt.Color(255, 255, 255));
        jPanel76.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recherche d'articles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcodearticle36.setText("Choisir description  article voulu ");

        cbDescriptionArticleModifier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDescriptionArticleModifierItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle36, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDescriptionArticleModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addComponent(lblcodearticle36, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbDescriptionArticleModifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panCorpsAjouterProduit4.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsAjouterProduit4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultat de la recherche ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcategorie4.setText("Categorie");

        lblcodearticle41.setText("Fournisseur");

        lblnomarticle5.setText("Quantite");

        txQuantiteArticleModifier.setText(" ");

        lblnomarticle24.setText("Prix Article");

        lblerreurnomarticle9.setForeground(new java.awt.Color(255, 0, 0));

        lblerreurprixarticle3.setForeground(new java.awt.Color(255, 0, 0));

        cbFournisseurSupprimer1.setToolTipText("Selectionner le fournisseur");
        cbFournisseurSupprimer1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFournisseurSupprimer1ItemStateChanged(evt);
            }
        });

        txtDescriptionArticleModifier.setBorder(javax.swing.BorderFactory.createTitledBorder("Description"));
        jScrollPane37.setViewportView(txtDescriptionArticleModifier);

        BtModifierArticle.setBackground(new java.awt.Color(204, 204, 204));
        BtModifierArticle.setText("Modifier");
        BtModifierArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierArticleActionPerformed(evt);
            }
        });

        jLabel104.setBackground(new java.awt.Color(0, 0, 0));
        jLabel104.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 153, 0));
        jLabel104.setText("Local");
        jLabel104.setToolTipText("");

        jLabel105.setBackground(new java.awt.Color(0, 0, 0));
        jLabel105.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 153, 0));
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setText("Brico");
        jLabel105.setToolTipText("");
        jLabel105.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator27.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator27.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator27.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panCorpsAjouterProduit4Layout = new javax.swing.GroupLayout(panCorpsAjouterProduit4);
        panCorpsAjouterProduit4.setLayout(panCorpsAjouterProduit4Layout);
        panCorpsAjouterProduit4Layout.setHorizontalGroup(
            panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsAjouterProduit4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panCorpsAjouterProduit4Layout.createSequentialGroup()
                        .addComponent(lblcodearticle41)
                        .addGap(18, 18, 18)
                        .addGroup(panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CbCategorieArticleModifier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbFournisseurSupprimer1, 0, 170, Short.MAX_VALUE)))
                    .addComponent(lblcategorie4)
                    .addComponent(jScrollPane37))
                .addGap(18, 18, 18)
                .addGroup(panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txPrixArticleModifier, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txQuantiteArticleModifier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                        .addComponent(BtModifierArticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblnomarticle5)
                    .addComponent(lblnomarticle24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsAjouterProduit4Layout.createSequentialGroup()
                        .addComponent(lblerreurprixarticle3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panCorpsAjouterProduit4Layout.createSequentialGroup()
                        .addComponent(lblerreurnomarticle9, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel105)
                            .addComponent(jLabel104))
                        .addContainerGap(38, Short.MAX_VALUE))))
        );
        panCorpsAjouterProduit4Layout.setVerticalGroup(
            panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsAjouterProduit4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsAjouterProduit4Layout.createSequentialGroup()
                        .addGroup(panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcodearticle41, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFournisseurSupprimer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnomarticle5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcategorie4)
                            .addComponent(CbCategorieArticleModifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txQuantiteArticleModifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panCorpsAjouterProduit4Layout.createSequentialGroup()
                                .addComponent(lblnomarticle24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txPrixArticleModifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtModifierArticle))
                            .addComponent(jScrollPane37))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsAjouterProduit4Layout.createSequentialGroup()
                        .addGroup(panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsAjouterProduit4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panCorpsAjouterProduit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCorpsAjouterProduit4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblerreurnomarticle9, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46))
                                    .addGroup(panCorpsAjouterProduit4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(panCorpsAjouterProduit4Layout.createSequentialGroup()
                                .addComponent(jSeparator27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(lblerreurprixarticle3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel76, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCorpsAjouterProduit4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panCorpsAjouterProduit4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        TbAjouterArticle.addTab("Modifier", jPanel9);

        panSupprimerArticle.setBackground(new java.awt.Color(255, 255, 255));

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));
        jPanel75.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recherche d'articles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcodearticle6.setText("Choisir numero article voulu supprimer ");

        cbRecherchersupprimerNumeroArt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRecherchersupprimerNumeroArt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRecherchersupprimerNumeroArtItemStateChanged(evt);
            }
        });

        lblcodearticle7.setText("Choisir description  article voulu supprimer ");

        cbRecherchersupprimerDescription.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle6)
                    .addComponent(cbRecherchersupprimerNumeroArt, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbRecherchersupprimerDescription, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblcodearticle7, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel75Layout.createSequentialGroup()
                        .addComponent(lblcodearticle6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRecherchersupprimerNumeroArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel75Layout.createSequentialGroup()
                        .addComponent(lblcodearticle7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbRecherchersupprimerDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        panCorpsAjouterProduit2.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsAjouterProduit2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultat de la recherche ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcategorie3.setText("Categorie");

        lblcodearticle8.setText("Fournisseur");

        lblnomarticle4.setText("Quantite");

        txQuantiteArticleSupprimer.setText(" ");

        lblnomarticle6.setText("Prix Article");

        lblerreurnomarticle2.setForeground(new java.awt.Color(255, 0, 0));

        lblerreurprixarticle2.setForeground(new java.awt.Color(255, 0, 0));

        txtDescriptionArticleSupprimer.setBorder(javax.swing.BorderFactory.createTitledBorder("Description"));
        jScrollPane20.setViewportView(txtDescriptionArticleSupprimer);

        BtSupprimerArticle.setBackground(new java.awt.Color(204, 204, 204));
        BtSupprimerArticle.setText("Supprimer");
        BtSupprimerArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSupprimerArticleActionPerformed(evt);
            }
        });

        jLabel90.setBackground(new java.awt.Color(0, 0, 0));
        jLabel90.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 153, 0));
        jLabel90.setText("Local");
        jLabel90.setToolTipText("");

        jLabel91.setBackground(new java.awt.Color(0, 0, 0));
        jLabel91.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 153, 0));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("Brico");
        jLabel91.setToolTipText("");
        jLabel91.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator8.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator8.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txFournisseurArticleSupprimer.setText(" ");

        txCategorieArticleSupprimer.setText(" ");

        javax.swing.GroupLayout panCorpsAjouterProduit2Layout = new javax.swing.GroupLayout(panCorpsAjouterProduit2);
        panCorpsAjouterProduit2.setLayout(panCorpsAjouterProduit2Layout);
        panCorpsAjouterProduit2Layout.setHorizontalGroup(
            panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsAjouterProduit2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsAjouterProduit2Layout.createSequentialGroup()
                        .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsAjouterProduit2Layout.createSequentialGroup()
                                .addComponent(lblcodearticle8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(panCorpsAjouterProduit2Layout.createSequentialGroup()
                                .addComponent(lblcategorie3)
                                .addGap(28, 28, 28)))
                        .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txCategorieArticleSupprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txFournisseurArticleSupprimer))))
                .addGap(28, 28, 28)
                .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txPrixArticleSupprimer)
                    .addComponent(BtSupprimerArticle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(txQuantiteArticleSupprimer, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panCorpsAjouterProduit2Layout.createSequentialGroup()
                        .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnomarticle4)
                            .addComponent(lblnomarticle6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(60, 60, 60)
                .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsAjouterProduit2Layout.createSequentialGroup()
                        .addComponent(lblerreurprixarticle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panCorpsAjouterProduit2Layout.createSequentialGroup()
                        .addComponent(lblerreurnomarticle2, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel91)
                            .addComponent(jLabel90))
                        .addContainerGap(41, Short.MAX_VALUE))))
        );
        panCorpsAjouterProduit2Layout.setVerticalGroup(
            panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsAjouterProduit2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsAjouterProduit2Layout.createSequentialGroup()
                        .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcodearticle8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnomarticle4)
                            .addComponent(txFournisseurArticleSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsAjouterProduit2Layout.createSequentialGroup()
                                .addComponent(txQuantiteArticleSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblnomarticle6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsAjouterProduit2Layout.createSequentialGroup()
                                .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblcategorie3)
                                    .addComponent(txCategorieArticleSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)))
                        .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panCorpsAjouterProduit2Layout.createSequentialGroup()
                                .addComponent(txPrixArticleSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtSupprimerArticle))
                            .addComponent(jScrollPane20))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsAjouterProduit2Layout.createSequentialGroup()
                        .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsAjouterProduit2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panCorpsAjouterProduit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCorpsAjouterProduit2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblerreurnomarticle2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46))
                                    .addGroup(panCorpsAjouterProduit2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(panCorpsAjouterProduit2Layout.createSequentialGroup()
                                .addComponent(jSeparator8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(lblerreurprixarticle2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout panSupprimerArticleLayout = new javax.swing.GroupLayout(panSupprimerArticle);
        panSupprimerArticle.setLayout(panSupprimerArticleLayout);
        panSupprimerArticleLayout.setHorizontalGroup(
            panSupprimerArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSupprimerArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSupprimerArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCorpsAjouterProduit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panSupprimerArticleLayout.setVerticalGroup(
            panSupprimerArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSupprimerArticleLayout.createSequentialGroup()
                .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCorpsAjouterProduit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panSupprimerArticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(panSupprimerArticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        TbAjouterArticle.addTab("Supprimer", jPanel2);

        panAfficherArticleStock.setBackground(new java.awt.Color(255, 255, 255));
        panAfficherArticleStock.setBorder(javax.swing.BorderFactory.createTitledBorder("Stock article"));

        tbListerArticle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero article", "Description", "Categorie", "Prix unitaire", "Qte en stock", "Date ajout", "Fournisseur", "Utilisateur"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbListerArticle.setToolTipText("");
        jScrollPane26.setViewportView(tbListerArticle);

        javax.swing.GroupLayout panAfficherArticleStockLayout = new javax.swing.GroupLayout(panAfficherArticleStock);
        panAfficherArticleStock.setLayout(panAfficherArticleStockLayout);
        panAfficherArticleStockLayout.setHorizontalGroup(
            panAfficherArticleStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAfficherArticleStockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addContainerGap())
        );
        panAfficherArticleStockLayout.setVerticalGroup(
            panAfficherArticleStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAfficherArticleStockLayout.createSequentialGroup()
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        TbAjouterArticle.addTab("Afficher", panAfficherArticleStock);

        javax.swing.GroupLayout ArticleLayout = new javax.swing.GroupLayout(Article);
        Article.setLayout(ArticleLayout);
        ArticleLayout.setHorizontalGroup(
            ArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TbAjouterArticle)
                .addContainerGap())
        );
        ArticleLayout.setVerticalGroup(
            ArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArticleLayout.createSequentialGroup()
                .addComponent(TbAjouterArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 66, Short.MAX_VALUE))
        );

        TbArticle.addTab("Article", Article);

        Payroll.setBackground(new java.awt.Color(255, 255, 255));
        Payroll.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        panEffectuerPayroll.setBackground(new java.awt.Color(255, 255, 255));

        pantetepayroll.setBackground(new java.awt.Color(255, 255, 255));
        pantetepayroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Preparation payroll"));

        jLabel1.setText("Choisir le mois payroll");

        cbxMoisPayroll.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir mois", "janvier", "fevrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre" }));
        cbxMoisPayroll.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMoisPayrollItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pantetepayrollLayout = new javax.swing.GroupLayout(pantetepayroll);
        pantetepayroll.setLayout(pantetepayrollLayout);
        pantetepayrollLayout.setHorizontalGroup(
            pantetepayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantetepayrollLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxMoisPayroll, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(lblMessagePayroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pantetepayrollLayout.setVerticalGroup(
            pantetepayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantetepayrollLayout.createSequentialGroup()
                .addGroup(pantetepayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxMoisPayroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessagePayroll, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
        );

        panPreparerPaiement1.setBackground(new java.awt.Color(255, 255, 255));
        panPreparerPaiement1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Validation preparation payroll", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        btnEffectuerPayroll.setText("Effectuer");
        btnEffectuerPayroll.setToolTipText("Effectuer payroll Employe");
        btnEffectuerPayroll.setVisible(false);
        btnEffectuerPayroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEffectuerPayrollActionPerformed(evt);
            }
        });

        lblMontantTotalPayroll.setText("|");

        lblNombreEmployeCharger.setText("|");

        javax.swing.GroupLayout panPreparerPaiement1Layout = new javax.swing.GroupLayout(panPreparerPaiement1);
        panPreparerPaiement1.setLayout(panPreparerPaiement1Layout);
        panPreparerPaiement1Layout.setHorizontalGroup(
            panPreparerPaiement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPreparerPaiement1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreEmployeCharger, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMontantTotalPayroll, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEffectuerPayroll, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panPreparerPaiement1Layout.setVerticalGroup(
            panPreparerPaiement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPreparerPaiement1Layout.createSequentialGroup()
                .addGroup(panPreparerPaiement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPreparerPaiement1Layout.createSequentialGroup()
                        .addComponent(btnEffectuerPayroll)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPreparerPaiement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombreEmployeCharger)
                        .addComponent(lblMontantTotalPayroll)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GrillePreparerPayroll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero", "Nom", "Prenom", "Mois", "SalaireBrut", "Taxe", "SalaireNet"
            }
        ));
        jScrollPane5.setViewportView(GrillePreparerPayroll);

        javax.swing.GroupLayout panEffectuerPayrollLayout = new javax.swing.GroupLayout(panEffectuerPayroll);
        panEffectuerPayroll.setLayout(panEffectuerPayrollLayout);
        panEffectuerPayrollLayout.setHorizontalGroup(
            panEffectuerPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panEffectuerPayrollLayout.createSequentialGroup()
                .addGroup(panEffectuerPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5)
                    .addComponent(pantetepayroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panPreparerPaiement1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panEffectuerPayrollLayout.setVerticalGroup(
            panEffectuerPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEffectuerPayrollLayout.createSequentialGroup()
                .addComponent(pantetepayroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panPreparerPaiement1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        Payroll.addTab("Effectuer", panEffectuerPayroll);

        panRechPayroll.setBackground(new java.awt.Color(255, 255, 255));

        cbxRechMoisPayroll.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxRechMoisPayrollItemStateChanged(evt);
            }
        });

        jLabel3.setText("Choisir mois payroll");

        grilleRechPayroll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero", "Nom", "Prenom", "Mois", "DatePayroll", "SalaireBrut", "Taxe", "SalireNet"
            }
        ));
        jScrollPane8.setViewportView(grilleRechPayroll);

        jLabel5.setText("Choisir date payroll");

        cbxRechDatePayroll.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxRechDatePayrollItemStateChanged(evt);
            }
        });

        btnAfficherPayroll.setText("Afficher tout");
        btnAfficherPayroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfficherPayrollActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panRechPayrollLayout = new javax.swing.GroupLayout(panRechPayroll);
        panRechPayroll.setLayout(panRechPayrollLayout);
        panRechPayrollLayout.setHorizontalGroup(
            panRechPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRechPayrollLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panRechPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                    .addGroup(panRechPayrollLayout.createSequentialGroup()
                        .addGroup(panRechPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxRechMoisPayroll, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(panRechPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panRechPayrollLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panRechPayrollLayout.createSequentialGroup()
                                .addComponent(cbxRechDatePayroll, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAfficherPayroll, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panRechPayrollLayout.setVerticalGroup(
            panRechPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRechPayrollLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panRechPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panRechPayrollLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxRechMoisPayroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panRechPayrollLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxRechDatePayroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAfficherPayroll))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        Payroll.addTab("Rechercher", panRechPayroll);

        TbArticle.addTab("Payroll", Payroll);

        Vente.setBackground(new java.awt.Color(255, 255, 255));
        Vente.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        panCorpsEffectuerVente3.setBackground(new java.awt.Color(255, 255, 255));
        panCorpsEffectuerVente3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ventes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        jLabel116.setBackground(new java.awt.Color(0, 0, 0));
        jLabel116.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(255, 153, 0));
        jLabel116.setText("Local");
        jLabel116.setToolTipText("");

        jLabel117.setBackground(new java.awt.Color(0, 0, 0));
        jLabel117.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(255, 153, 0));
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setText("Brico");
        jLabel117.setToolTipText("");
        jLabel117.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator34.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator34.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator34.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel14.setText("Nom client");

        jLabel15.setText("Telephone");

        jLabel20.setText("Adresse");

        txtNomClient.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomClientCaretUpdate(evt);
            }
        });

        txtTelephoneClient.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelephoneClientCaretUpdate(evt);
            }
        });

        txtAdresseClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdresseClientActionPerformed(evt);
            }
        });

        panSaisieArticle.setBackground(new java.awt.Color(255, 255, 255));
        panSaisieArticle.setBorder(javax.swing.BorderFactory.createTitledBorder("Vente  articles"));

        jLabel73.setText("Libelle");

        cbxLibelleArticleVente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir article" }));
        cbxLibelleArticleVente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLibelleArticleVenteItemStateChanged(evt);
            }
        });
        cbxLibelleArticleVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLibelleArticleVenteActionPerformed(evt);
            }
        });

        jLabel83.setText("Prix");

        txtPrixArticleVente.setEditable(false);

        jLabel74.setText("Quantite");

        label12.setBackground(new java.awt.Color(153, 153, 153));
        label12.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        label12.setForeground(new java.awt.Color(0, 0, 0));
        label12.setText("Nombre articles");

        lblNombreArticleVente.setBackground(new java.awt.Color(255, 255, 255));
        lblNombreArticleVente.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblNombreArticleVente.setForeground(new java.awt.Color(51, 204, 0));

        label13.setBackground(new java.awt.Color(153, 153, 153));
        label13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        label13.setForeground(new java.awt.Color(0, 0, 0));
        label13.setText("Prix total vente");

        lblPrixtotalvente.setBackground(new java.awt.Color(255, 255, 255));
        lblPrixtotalvente.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblPrixtotalvente.setForeground(new java.awt.Color(51, 204, 0));

        label14.setBackground(new java.awt.Color(153, 153, 153));
        label14.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        label14.setForeground(new java.awt.Color(0, 0, 0));
        label14.setText("Montant recu");

        txMontantRecu.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txMontantRecuCaretUpdate(evt);
            }
        });

        btnValiderVente.setText("Valider");
        btnValiderVente.setEnabled(false);
        btnValiderVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValiderVenteActionPerformed(evt);
            }
        });

        btnVenteVente.setText("Annuler");
        btnVenteVente.setEnabled(false);
        btnVenteVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenteVenteActionPerformed(evt);
            }
        });

        btnAjouterLigneVente.setText("Ajouter");
        btnAjouterLigneVente.setEnabled(false);
        btnAjouterLigneVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterLigneVenteActionPerformed(evt);
            }
        });

        txtQuantiteArticleVente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtQuantiteArticleVenteCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout panSaisieArticleLayout = new javax.swing.GroupLayout(panSaisieArticle);
        panSaisieArticle.setLayout(panSaisieArticleLayout);
        panSaisieArticleLayout.setHorizontalGroup(
            panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSaisieArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panSaisieArticleLayout.createSequentialGroup()
                        .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel73)
                            .addComponent(jLabel83))
                        .addGap(31, 31, 31)
                        .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrixArticleVente)
                            .addComponent(cbxLibelleArticleVente, 0, 191, Short.MAX_VALUE)))
                    .addGroup(panSaisieArticleLayout.createSequentialGroup()
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantiteArticleVente)
                            .addComponent(btnAjouterLigneVente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSaisieArticleLayout.createSequentialGroup()
                        .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPrixtotalvente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreArticleVente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txMontantRecu, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addGap(10, 10, 10))
                    .addGroup(panSaisieArticleLayout.createSequentialGroup()
                        .addComponent(btnValiderVente, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVenteVente)))
                .addGap(19, 19, 19))
        );
        panSaisieArticleLayout.setVerticalGroup(
            panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSaisieArticleLayout.createSequentialGroup()
                .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombreArticleVente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(cbxLibelleArticleVente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel83)
                        .addComponent(txtPrixArticleVente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrixtotalvente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSaisieArticleLayout.createSequentialGroup()
                        .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel74)
                            .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantiteArticleVente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(panSaisieArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnValiderVente)
                            .addComponent(btnVenteVente)
                            .addComponent(btnAjouterLigneVente)))
                    .addComponent(txMontantRecu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtEmailClient.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEmailClientCaretUpdate(evt);
            }
        });

        jLabel37.setText("Email");

        grilleVente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Utilisateur", "Categorie", "Article", "Quantite", "Prix unitaire", "Sous-total"
            }
        ));
        grilleVente.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane7.setViewportView(grilleVente);

        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/dec.png"))); // NOI18N
        jLabel7.setText("Retirer Article non desire");
        jLabel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chosir Index", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        cbxRetirerArticleVente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxRetirerArticleVenteItemStateChanged(evt);
            }
        });

        btnRetirerArticleVente.setText("Enlever");
        btnRetirerArticleVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirerArticleVenteActionPerformed(evt);
            }
        });

        lblMessageVente.setBackground(new java.awt.Color(255, 255, 255));
        lblMessageVente.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblMessageVente.setForeground(new java.awt.Color(51, 204, 0));

        javax.swing.GroupLayout panCorpsEffectuerVente3Layout = new javax.swing.GroupLayout(panCorpsEffectuerVente3);
        panCorpsEffectuerVente3.setLayout(panCorpsEffectuerVente3Layout);
        panCorpsEffectuerVente3Layout.setHorizontalGroup(
            panCorpsEffectuerVente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsEffectuerVente3Layout.createSequentialGroup()
                .addGroup(panCorpsEffectuerVente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panSaisieArticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panCorpsEffectuerVente3Layout.createSequentialGroup()
                        .addGroup(panCorpsEffectuerVente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panCorpsEffectuerVente3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNomClient, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panCorpsEffectuerVente3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelephoneClient)))
                        .addGroup(panCorpsEffectuerVente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsEffectuerVente3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCorpsEffectuerVente3Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel37)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panCorpsEffectuerVente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCorpsEffectuerVente3Layout.createSequentialGroup()
                                .addComponent(lblMessageClient)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtEmailClient)
                            .addComponent(txtAdresseClient)))
                    .addComponent(lblMessageVente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator34, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCorpsEffectuerVente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel117)
                    .addComponent(jLabel116)
                    .addGroup(panCorpsEffectuerVente3Layout.createSequentialGroup()
                        .addComponent(cbxRetirerArticleVente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRetirerArticleVente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panCorpsEffectuerVente3Layout.setVerticalGroup(
            panCorpsEffectuerVente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsEffectuerVente3Layout.createSequentialGroup()
                .addGroup(panCorpsEffectuerVente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsEffectuerVente3Layout.createSequentialGroup()
                        .addGroup(panCorpsEffectuerVente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtNomClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAdresseClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCorpsEffectuerVente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtTelephoneClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)
                            .addComponent(txtEmailClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMessageClient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panSaisieArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMessageVente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCorpsEffectuerVente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panCorpsEffectuerVente3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jSeparator34))
                        .addGroup(panCorpsEffectuerVente3Layout.createSequentialGroup()
                            .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panCorpsEffectuerVente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxRetirerArticleVente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRetirerArticleVente)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panEffectuerVenteLayout = new javax.swing.GroupLayout(panEffectuerVente);
        panEffectuerVente.setLayout(panEffectuerVenteLayout);
        panEffectuerVenteLayout.setHorizontalGroup(
            panEffectuerVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panCorpsEffectuerVente3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panEffectuerVenteLayout.setVerticalGroup(
            panEffectuerVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEffectuerVenteLayout.createSequentialGroup()
                .addComponent(panCorpsEffectuerVente3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        Vente.addTab("Effectuer", panEffectuerVente);

        panRechercherVente.setBackground(new java.awt.Color(255, 255, 255));

        panrechVente.setBackground(new java.awt.Color(255, 255, 255));
        panrechVente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recherche vente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 0)));

        lblcodearticle34.setText("Saisir indice de recherche  vente");

        txtNumeroVenteArticle.setToolTipText("Taper Nom vendeur ou date vente ou numero vente...");
        txtNumeroVenteArticle.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNumeroVenteArticleCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout panrechVenteLayout = new javax.swing.GroupLayout(panrechVente);
        panrechVente.setLayout(panrechVenteLayout);
        panrechVenteLayout.setHorizontalGroup(
            panrechVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panrechVenteLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(panrechVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumeroVenteArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcodearticle34, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panrechVenteLayout.setVerticalGroup(
            panrechVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panrechVenteLayout.createSequentialGroup()
                .addGroup(panrechVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodearticle34)
                    .addGroup(panrechVenteLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtNumeroVenteArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Grillerechvente.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 204, 0), new java.awt.Color(255, 153, 0)));
        Grillerechvente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Utilisateur", "Categorie", "Article", "Quantite", "Prix", "Sous-Total", "Date Vente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(Grillerechvente);

        javax.swing.GroupLayout panRechercherVenteLayout = new javax.swing.GroupLayout(panRechercherVente);
        panRechercherVente.setLayout(panRechercherVenteLayout);
        panRechercherVenteLayout.setHorizontalGroup(
            panRechercherVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panrechVente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
        );
        panRechercherVenteLayout.setVerticalGroup(
            panRechercherVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRechercherVenteLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panrechVente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );

        Vente.addTab("Rechercher", panRechercherVente);

        panAfficherVente.setBackground(new java.awt.Color(255, 255, 255));
        panAfficherVente.setBorder(javax.swing.BorderFactory.createTitledBorder("Affichage vente"));

        GrilleAffichervente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Utilisateur", "Categorie", "Article", "Quantite", "Prix", "Sous-Total", "Date Vente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(GrilleAffichervente);

        javax.swing.GroupLayout panAfficherVenteLayout = new javax.swing.GroupLayout(panAfficherVente);
        panAfficherVente.setLayout(panAfficherVenteLayout);
        panAfficherVenteLayout.setHorizontalGroup(
            panAfficherVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        panAfficherVenteLayout.setVerticalGroup(
            panAfficherVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAfficherVenteLayout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 100, Short.MAX_VALUE))
        );

        Vente.addTab("Afficher", panAfficherVente);

        TbArticle.addTab("Vente", Vente);

        Outils.setBackground(new java.awt.Color(255, 255, 255));
        Outils.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Outils.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OutilsMouseClicked(evt);
            }
        });
        Outils.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                OutilsMouseMoved(evt);
            }
        });

        panCorpsOutilsEmploye2.setBackground(new java.awt.Color(255, 255, 255));

        lblerreurnomarticle17.setForeground(new java.awt.Color(255, 0, 0));

        jLabel112.setBackground(new java.awt.Color(0, 0, 0));
        jLabel112.setFont(new java.awt.Font("TypoUpright BT", 1, 80)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 153, 0));
        jLabel112.setText("Local");
        jLabel112.setToolTipText("");

        jLabel113.setBackground(new java.awt.Color(0, 0, 0));
        jLabel113.setFont(new java.awt.Font("TypoUpright BT", 3, 80)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 153, 0));
        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel113.setText("Brico");
        jLabel113.setToolTipText("");
        jLabel113.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator32.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator32.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator32.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));
        jPanel70.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ajout de fonction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(255, 153, 0))); // NOI18N

        lbltelephonefournissuer15.setText("Editer fonction");

        lblemail14.setText("Nombre salaries lies");

        txtFonction1.setMaximumSize(new java.awt.Dimension(21, 2147483647));

        btnEnregistrerFonction1.setMnemonic('a');
        btnEnregistrerFonction1.setText("Valider");
        btnEnregistrerFonction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerFonction1ActionPerformed(evt);
            }
        });

        txtSalairemin.setText(" ");
        txtSalairemin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaireminActionPerformed(evt);
            }
        });

        txtSalairemax.setText(" ");
        txtSalairemax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalairemaxActionPerformed(evt);
            }
        });

        lblemail11.setText("Salaire maximum");

        lbltelephonefournissuer11.setText("Salaire minimum");

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnregistrerFonction1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel70Layout.createSequentialGroup()
                        .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbltelephonefournissuer15)
                            .addComponent(lbltelephonefournissuer11)
                            .addComponent(txtSalairemin, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(txtFonction1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblemail11)
                            .addComponent(lblemail14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtQuantiteEmploye)
                            .addComponent(txtSalairemax))))
                .addContainerGap())
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltelephonefournissuer15)
                    .addComponent(lblemail14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQuantiteEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFonction1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblemail11)
                    .addComponent(lbltelephonefournissuer11))
                .addGap(4, 4, 4)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalairemax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalairemin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnregistrerFonction1)
                .addContainerGap())
        );

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));
        jPanel72.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modification de fonction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(255, 153, 0))); // NOI18N

        lblemail15.setText("Nombre salaries");

        btnModifierFonction1.setMnemonic('a');
        btnModifierFonction1.setText("Modifier");
        btnModifierFonction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierFonction1ActionPerformed(evt);
            }
        });

        cbFonctionMod1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir  fonction" }));
        cbFonctionMod1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFonctionMod1ItemStateChanged(evt);
            }
        });

        btnSupprimerFonction1.setText("Supprimer");
        btnSupprimerFonction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerFonction1ActionPerformed(evt);
            }
        });

        txtSalairemax3.setText(" ");
        txtSalairemax3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalairemax3ActionPerformed(evt);
            }
        });

        lblemail12.setText("Salaire maximum");

        lbltelephonefournissuer12.setText("Salaire minimum");

        txtSalairemin3.setText(" ");
        txtSalairemin3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalairemin3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                        .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbFonctionMod1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModifierFonction1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblemail15)
                            .addComponent(txtQuantiteEmployeMod1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSupprimerFonction1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel72Layout.createSequentialGroup()
                        .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel72Layout.createSequentialGroup()
                                .addComponent(lbltelephonefournissuer12)
                                .addGap(73, 73, 73))
                            .addComponent(txtSalairemin3, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel72Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 27, Short.MAX_VALUE)
                                .addComponent(lblemail12))
                            .addGroup(jPanel72Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(txtSalairemax3)))))
                .addContainerGap())
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel72Layout.createSequentialGroup()
                        .addComponent(lblemail15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantiteEmployeMod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbFonctionMod1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblemail12)
                    .addComponent(lbltelephonefournissuer12))
                .addGap(4, 4, 4)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalairemax3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalairemin3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSupprimerFonction1)
                    .addComponent(btnModifierFonction1))
                .addGap(0, 47, Short.MAX_VALUE))
        );

        panPrelevement1.setBackground(new java.awt.Color(255, 255, 255));
        panPrelevement1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modification  taxes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 51)));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("TCA en %");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("ONA en %");

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("SANTE en %");

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("VIE en %");

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("MORT en %");

        txtOna.setMaximumSize(new java.awt.Dimension(21, 2147483647));

        txtTca.setMaximumSize(new java.awt.Dimension(21, 2147483647));

        txtSante.setMaximumSize(new java.awt.Dimension(21, 2147483647));

        txtMort.setMaximumSize(new java.awt.Dimension(21, 2147483647));

        txtVie.setMaximumSize(new java.awt.Dimension(21, 2147483647));

        btnModifierTaxe.setText("Modifier");
        btnModifierTaxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierTaxeActionPerformed(evt);
            }
        });

        lblTeteDepartement.setForeground(new java.awt.Color(255, 153, 0));
        lblTeteDepartement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTeteDepartement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/modi.png"))); // NOI18N
        lblTeteDepartement.setText("Case de modification departement ");
        lblTeteDepartement.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 0)));

        jLabel6.setText("Departement");

        btnAjouterDepartement.setText("Ajouter");
        btnAjouterDepartement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterDepartementActionPerformed(evt);
            }
        });

        cbxModifierDepartement.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir departement" }));
        cbxModifierDepartement.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxModifierDepartementItemStateChanged(evt);
            }
        });

        txtModifierDepartement.setBorder(javax.swing.BorderFactory.createTitledBorder("Nouveau departement"));
        jScrollPane39.setViewportView(txtModifierDepartement);

        btnModifierDepartement.setText("Modifier");
        btnModifierDepartement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierDepartementActionPerformed(evt);
            }
        });

        btnSupprimerDepartement.setText("Supprimer");
        btnSupprimerDepartement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerDepartementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panPrelevement1Layout = new javax.swing.GroupLayout(panPrelevement1);
        panPrelevement1.setLayout(panPrelevement1Layout);
        panPrelevement1Layout.setHorizontalGroup(
            panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTeteDepartement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnModifierTaxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panPrelevement1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrelevement1Layout.createSequentialGroup()
                        .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxModifierDepartement, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModifierDepartement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSupprimerDepartement, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panPrelevement1Layout.createSequentialGroup()
                        .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panPrelevement1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAjouterDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAjouterDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panPrelevement1Layout.createSequentialGroup()
                                .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtMort, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(txtSante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtOna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtVie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtTca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panPrelevement1Layout.setVerticalGroup(
            panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrelevement1Layout.createSequentialGroup()
                .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txtTca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(txtOna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(txtSante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModifierTaxe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTeteDepartement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAjouterDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAjouterDepartement)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxModifierDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrelevement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panPrelevement1Layout.createSequentialGroup()
                        .addComponent(btnModifierDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSupprimerDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panCorpsOutilsEmploye2Layout = new javax.swing.GroupLayout(panCorpsOutilsEmploye2);
        panCorpsOutilsEmploye2.setLayout(panCorpsOutilsEmploye2Layout);
        panCorpsOutilsEmploye2Layout.setHorizontalGroup(
            panCorpsOutilsEmploye2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsOutilsEmploye2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCorpsOutilsEmploye2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panPrelevement1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jSeparator32, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerreurnomarticle17, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCorpsOutilsEmploye2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel113)
                    .addComponent(jLabel112)))
        );
        panCorpsOutilsEmploye2Layout.setVerticalGroup(
            panCorpsOutilsEmploye2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsOutilsEmploye2Layout.createSequentialGroup()
                .addGroup(panCorpsOutilsEmploye2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCorpsOutilsEmploye2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblerreurnomarticle17, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCorpsOutilsEmploye2Layout.createSequentialGroup()
                        .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCorpsOutilsEmploye2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator32, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panPrelevement1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panCorpsOutilsEmploye2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(panCorpsOutilsEmploye2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );

        Outils.addTab("Gestion Outils", jPanel10);

        panHistorique.setBackground(new java.awt.Color(255, 255, 255));

        btnTraceUtilisateur.setText("Afficher tout");
        btnTraceUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraceUtilisateurActionPerformed(evt);
            }
        });

        jtTracee.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 153, 0), null, java.awt.Color.orange));
        jtTracee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numero categorie", "Description", "Date ajout"
            }
        ));
        jScrollPane38.setViewportView(jtTracee);

        txtIndiceTracee.setToolTipText("Taper nom Utilisateur ou date action ou Action effectuee ou Entite...");
        txtIndiceTracee.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtIndiceTraceeCaretUpdate(evt);
            }
        });

        jLabel9.setText("Taper indice de recherche");

        javax.swing.GroupLayout panHistoriqueLayout = new javax.swing.GroupLayout(panHistorique);
        panHistorique.setLayout(panHistoriqueLayout);
        panHistoriqueLayout.setHorizontalGroup(
            panHistoriqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panHistoriqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panHistoriqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panHistoriqueLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIndiceTracee, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addComponent(btnTraceUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane38, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE))
                .addContainerGap())
        );
        panHistoriqueLayout.setVerticalGroup(
            panHistoriqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panHistoriqueLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panHistoriqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTraceUtilisateur)
                    .addComponent(txtIndiceTracee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Outils.addTab("Historique", panHistorique);

        TbArticle.addTab("Outil", Outils);

        panTete.setBackground(new java.awt.Color(255, 255, 255));
        panTete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 4));

        barreoutils.setBackground(new java.awt.Color(255, 255, 255));
        barreoutils.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        barreoutils.setFloatable(false);
        barreoutils.setForeground(java.awt.SystemColor.scrollbar);
        barreoutils.setRollover(true);

        btnQuitterApplication.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/quit.png"))); // NOI18N
        btnQuitterApplication.setText("Quitter");
        btnQuitterApplication.setToolTipText("Cliquer pour quitter SysGesBricoLocal");
        btnQuitterApplication.setFocusable(false);
        btnQuitterApplication.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuitterApplication.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQuitterApplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitterApplicationActionPerformed(evt);
            }
        });
        barreoutils.add(btnQuitterApplication);
        barreoutils.add(jSeparator23);

        btnDeconnecter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/dec.png"))); // NOI18N
        btnDeconnecter.setText("Deconnecter");
        btnDeconnecter.setToolTipText("Deconnexion utilisateur SysgesBricoLocal");
        btnDeconnecter.setFocusable(false);
        btnDeconnecter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeconnecter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeconnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeconnecterActionPerformed(evt);
            }
        });
        barreoutils.add(btnDeconnecter);
        barreoutils.add(jSeparator20);

        btnChagerMotPasseUt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/user.png"))); // NOI18N
        btnChagerMotPasseUt.setText("Utilisateur");
        btnChagerMotPasseUt.setToolTipText("gestion utilisateur");
        btnChagerMotPasseUt.setFocusable(false);
        btnChagerMotPasseUt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChagerMotPasseUt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChagerMotPasseUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChagerMotPasseUtActionPerformed(evt);
            }
        });
        barreoutils.add(btnChagerMotPasseUt);
        barreoutils.add(jSeparator21);

        btnEmploye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/embEmpl.png"))); // NOI18N
        btnEmploye.setText("Employe");
        btnEmploye.setFocusable(false);
        btnEmploye.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmploye.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmploye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeActionPerformed(evt);
            }
        });
        barreoutils.add(btnEmploye);
        barreoutils.add(jSeparator17);

        btnPayroll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/pay.png"))); // NOI18N
        btnPayroll.setText("Payroll");
        btnPayroll.setFocusable(false);
        btnPayroll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPayroll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPayroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayrollActionPerformed(evt);
            }
        });
        barreoutils.add(btnPayroll);
        barreoutils.add(jSeparator19);

        btnOutil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/outil.jpg"))); // NOI18N
        btnOutil.setText("Outil");
        btnOutil.setFocusable(false);
        btnOutil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOutil.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOutil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutilActionPerformed(evt);
            }
        });
        barreoutils.add(btnOutil);
        barreoutils.add(jSeparator18);

        btnArticle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/articl.jpg"))); // NOI18N
        btnArticle.setText("Article");
        btnArticle.setFocusable(false);
        btnArticle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnArticle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticleActionPerformed(evt);
            }
        });
        barreoutils.add(btnArticle);
        barreoutils.add(jSeparator22);

        btnVente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/vente.jpg"))); // NOI18N
        btnVente.setText("Vente");
        btnVente.setFocusable(false);
        btnVente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenteActionPerformed(evt);
            }
        });
        barreoutils.add(btnVente);
        barreoutils.add(jSeparator11);

        btnFournisseur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/fournisseur.jpg"))); // NOI18N
        btnFournisseur.setText("Fournisseur");
        btnFournisseur.setFocusable(false);
        btnFournisseur.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFournisseur.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barreoutils.add(btnFournisseur);
        barreoutils.add(jSeparator12);

        btnCategorie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/categorie.jpg"))); // NOI18N
        btnCategorie.setText("Categorie");
        btnCategorie.setFocusable(false);
        btnCategorie.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCategorie.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategorieActionPerformed(evt);
            }
        });
        barreoutils.add(btnCategorie);
        barreoutils.add(jSeparator13);

        btnAchat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/achat.jpg"))); // NOI18N
        btnAchat.setText("Achat");
        btnAchat.setFocusable(false);
        btnAchat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAchat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAchatActionPerformed(evt);
            }
        });
        barreoutils.add(btnAchat);
        barreoutils.add(jSeparator14);

        btnMenuGauche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/left.png"))); // NOI18N
        btnMenuGauche.setText("Gauche");
        btnMenuGauche.setToolTipText("Cliquer pour positionner menu vers la gauche");
        btnMenuGauche.setFocusable(false);
        btnMenuGauche.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMenuGauche.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMenuGauche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuGaucheActionPerformed(evt);
            }
        });
        barreoutils.add(btnMenuGauche);
        barreoutils.add(jSeparator15);

        btnMenuHaut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/up.png"))); // NOI18N
        btnMenuHaut.setText("Haut");
        btnMenuHaut.setToolTipText("Cliquer pour positionner menu vers le haut");
        btnMenuHaut.setFocusable(false);
        btnMenuHaut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMenuHaut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMenuHaut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuHautActionPerformed(evt);
            }
        });
        barreoutils.add(btnMenuHaut);
        barreoutils.add(jSeparator24);

        btnMenuDroite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/right.png"))); // NOI18N
        btnMenuDroite.setText("Droite");
        btnMenuDroite.setToolTipText("Cliquer pour positionner menu vers la droite");
        btnMenuDroite.setFocusable(false);
        btnMenuDroite.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMenuDroite.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMenuDroite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuDroiteActionPerformed(evt);
            }
        });
        barreoutils.add(btnMenuDroite);
        barreoutils.add(jSeparator30);

        lblUtilisateurconnecter.setText("|");
        barreoutils.add(lblUtilisateurconnecter);

        javax.swing.GroupLayout panTeteLayout = new javax.swing.GroupLayout(panTete);
        panTete.setLayout(panTeteLayout);
        panTeteLayout.setHorizontalGroup(
            panTeteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barreoutils, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panTeteLayout.setVerticalGroup(
            panTeteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTeteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(barreoutils, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panpiedImage.setBackground(new java.awt.Color(255, 255, 255));

        lblPied1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/piedConnexion.jpg"))); // NOI18N
        lblPied1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/rech.png"))); // NOI18N
        jLabel10.setText("@ Compagnon des chercheurs Unasmoh 2015.            Version 2.0");
        jLabel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblPied2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/piedConnexion.jpg"))); // NOI18N
        lblPied2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panpiedImageLayout = new javax.swing.GroupLayout(panpiedImage);
        panpiedImage.setLayout(panpiedImageLayout);
        panpiedImageLayout.setHorizontalGroup(
            panpiedImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panpiedImageLayout.createSequentialGroup()
                .addComponent(lblPied2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPied1)
                .addGap(2, 2, 2))
        );
        panpiedImageLayout.setVerticalGroup(
            panpiedImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panpiedImageLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panpiedImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPied2)
                    .addGroup(panpiedImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPied1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panCorpsConnexion.setBackground(new java.awt.Color(255, 204, 0));
        panCorpsConnexion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panConnexion.setBackground(new java.awt.Color(255, 255, 255));
        panConnexion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Nom Utilisateur");

        txtNomUtilisateurConn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtNomUtilisateurConn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomUtilisateurConnActionPerformed(evt);
            }
        });

        jLabel4.setText("Mot de passe");

        btnConnecter.setBackground(new java.awt.Color(204, 204, 204));
        btnConnecter.setText("Connecter");
        btnConnecter.setBorder(null);
        btnConnecter.setFocusCycleRoot(true);
        btnConnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnecterActionPerformed(evt);
            }
        });

        btnQuitterConnexion.setBackground(new java.awt.Color(204, 204, 204));
        btnQuitterConnexion.setText("Quitter");
        btnQuitterConnexion.setBorder(null);
        btnQuitterConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitterConnexionActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/user.png"))); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtMotdemasseConn.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMotdemasseConnCaretUpdate(evt);
            }
        });
        txtMotdemasseConn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMotdemasseConnActionPerformed(evt);
            }
        });

        lblMessageConn.setText(" ");

        lblPied.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ht/sys/sysgesbricolocal/img/piedConnexion.jpg"))); // NOI18N
        lblPied.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblTeteConnexion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTeteConnexion.setText("Connexion utilisateur");
        lblTeteConnexion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout panConnexionLayout = new javax.swing.GroupLayout(panConnexion);
        panConnexion.setLayout(panConnexionLayout);
        panConnexionLayout.setHorizontalGroup(
            panConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConnexionLayout.createSequentialGroup()
                .addComponent(lblPied)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panConnexionLayout.createSequentialGroup()
                .addGroup(panConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panConnexionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panConnexionLayout.createSequentialGroup()
                                .addGroup(panConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMotdemasseConn)
                                    .addComponent(txtNomUtilisateurConn)
                                    .addGroup(panConnexionLayout.createSequentialGroup()
                                        .addComponent(btnQuitterConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnConnecter, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))))
                            .addComponent(lblMessageConn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblTeteConnexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panConnexionLayout.setVerticalGroup(
            panConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panConnexionLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lblTeteConnexion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomUtilisateurConn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMotdemasseConn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnecter, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitterConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessageConn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPied, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panCorpsConnexionLayout = new javax.swing.GroupLayout(panCorpsConnexion);
        panCorpsConnexion.setLayout(panCorpsConnexionLayout);
        panCorpsConnexionLayout.setHorizontalGroup(
            panCorpsConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCorpsConnexionLayout.createSequentialGroup()
                .addComponent(panConnexion, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );
        panCorpsConnexionLayout.setVerticalGroup(
            panCorpsConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        JtChagerDepartement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(JtChagerDepartement);

        jtChargerFonction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane4.setViewportView(jtChargerFonction);

        jtChargerNumEmploye.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NumeroEmploye"
            }
        ));
        jScrollPane10.setViewportView(jtChargerNumEmploye);

        jtgrilleNom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NumeroEmploye"
            }
        ));
        jScrollPane13.setViewportView(jtgrilleNom);

        jtChargerUtilisateur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane14.setViewportView(jtChargerUtilisateur);

        cbxLigneVente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "bo;jo;to;lo;po;1", "bo;jo;to;lo;po;2", "bo;jo;to;lo;po;3", "bo;jo;to;lo;po;4", "bo;jo;to;lo;po;5", "bo;jo;to;lo;po;6", "bo;jo;to;lo;po;7" }));

        jtgrilleNomArticle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NumeroEmploye"
            }
        ));
        jScrollPane27.setViewportView(jtgrilleNomArticle);

        jTextField1.setText("bo;jo;to;lo;po;1");

        cbxvt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxvtActionPerformed(evt);
            }
        });

        jtChargerVendeur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NumeroEmploye"
            }
        ));
        jScrollPane29.setViewportView(jtChargerVendeur);

        jtChargerDateVente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NumeroEmploye"
            }
        ));
        jScrollPane34.setViewportView(jtChargerDateVente);

        jtChargerNumeroVente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NumeroEmploye"
            }
        ));
        jScrollPane35.setViewportView(jtChargerNumeroVente);

        jtTraceeDate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NumeroEmploye"
            }
        ));
        jScrollPane41.setViewportView(jtTraceeDate);

        jtTraceeAction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NumeroEmploye"
            }
        ));
        jScrollPane42.setViewportView(jtTraceeAction);

        jtTraceeTableAffectee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NumeroEmploye"
            }
        ));
        jScrollPane43.setViewportView(jtTraceeTableAffectee);

        jtTraceeNomutilisateur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NumeroEmploye"
            }
        ));
        jScrollPane23.setViewportView(jtTraceeNomutilisateur);

        jtChargerMoisPayroll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NumeroEmploye"
            }
        ));
        jScrollPane44.setViewportView(jtChargerMoisPayroll);

        jtChargerDatePayrolll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NumeroEmploye"
            }
        ));
        jScrollPane45.setViewportView(jtChargerDatePayrolll);

        BMnMenuPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        BMnMenuPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Systeme de gestion Brico Local", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), java.awt.Color.darkGray)); // NOI18N

        mnUtilisateur.setBackground(new java.awt.Color(204, 204, 204));
        mnUtilisateur.setText("Utilisateur");
        mnUtilisateur.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mnUtilisateurMouseMoved(evt);
            }
        });
        BMnMenuPrincipal.add(mnUtilisateur);

        mnEmploye.setText("Employe");
        mnEmploye.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mnEmployeMouseMoved(evt);
            }
        });
        BMnMenuPrincipal.add(mnEmploye);

        mnFournisseur.setText("Fournisseur");
        mnFournisseur.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mnFournisseurMouseMoved(evt);
            }
        });
        BMnMenuPrincipal.add(mnFournisseur);

        mnCategorie.setText("Categorie");
        mnCategorie.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mnCategorieMouseMoved(evt);
            }
        });
        BMnMenuPrincipal.add(mnCategorie);

        mnArticle.setText("Article");
        BMnMenuPrincipal.add(mnArticle);

        mnPayroll.setText("Payroll");
        mnPayroll.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mnPayrollMouseMoved(evt);
            }
        });
        BMnMenuPrincipal.add(mnPayroll);

        mnAchat.setText("Achat");
        mnAchat.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mnAchatMouseMoved(evt);
            }
        });
        BMnMenuPrincipal.add(mnAchat);

        MnVente.setText("Vente");
        MnVente.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MnVenteMouseMoved(evt);
            }
        });
        BMnMenuPrincipal.add(MnVente);

        mnOutil.setText("Outil");
        mnOutil.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mnOutilMouseMoved(evt);
            }
        });
        BMnMenuPrincipal.add(mnOutil);

        setJMenuBar(BMnMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panpiedImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TbArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(panTete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panCorpsConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxLigneVente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxvt, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane43, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane41, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane44, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane45, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane42, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panTete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TbArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panpiedImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxLigneVente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(cbxvt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane43, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane41, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane42, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane44, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane45, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panCorpsConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuitterApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitterApplicationActionPerformed
        if (Nomutilisateur != "") {
            JOptionPane.showMessageDialog(null, "Votre compte est ouvert,Deconnectez d'abord svp " + Nomutilisateur + "!", "Fermeture rejettee", JOptionPane.INFORMATION_MESSAGE);

        } else {

            int i = JOptionPane.showConfirmDialog(null, "Etes vous sur de vouloir quitter SysgesBricoLocal ?", "Confirmer", 2);
            if (i == 0) {
                System.exit(0);
            }
        }
    }//GEN-LAST:event_btnQuitterApplicationActionPerformed

    private void btnMenuGaucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuGaucheActionPerformed
        // TODO add your handling code here:
        TbArticle.setTabPlacement(2);
        TbAjouterArticle.setTabPlacement(2);
        Categorie.setTabPlacement(2);
//                Commande.setTabPlacement(2);
        Utilisateur.setTabPlacement(2);
        Outils.setTabPlacement(2);
        Employe.setTabPlacement(2);
        Fournisseur.setTabPlacement(2);
        Payroll.setTabPlacement(2);
        Vente.setTabPlacement(2);
        Achat.setTabPlacement(2);
        haut = false;
        gauche = false;
        droite = false;
        bas = true;
    }//GEN-LAST:event_btnMenuGaucheActionPerformed

    private void btnMenuDroiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuDroiteActionPerformed
        TbArticle.setTabPlacement(4);
        TbAjouterArticle.setTabPlacement(4);
        Categorie.setTabPlacement(4);
//                Commande.setTabPlacement(4);
        Utilisateur.setTabPlacement(4);
        Outils.setTabPlacement(4);
        Employe.setTabPlacement(4);
        Fournisseur.setTabPlacement(4);
        Payroll.setTabPlacement(4);
        Vente.setTabPlacement(4);
        Achat.setTabPlacement(4);
        droite = false;
        bas = false;
        haut = false;
        gauche = true;
    }//GEN-LAST:event_btnMenuDroiteActionPerformed

    private void BtAjouterArticleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtAjouterArticleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BtAjouterArticleMouseClicked

    private void btnajouterFournisseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnajouterFournisseurActionPerformed
        if (txtNomFournisseur.getText().equals("") || txtAdresselFournisseur.getText().equals("") || txTelephoneFournisseur.getText().equals("") || txtEmaillFournisseur.getText().equals("")) {
            lblMessageFournisseur.setForeground(Color.red);
            lblMessageFournisseur.setText("Remplir les champs vides");
        } else {
            if (!txtEmaillFournisseur.getText().matches(ser.patternemail) || txtEmaillFournisseur.getText().contains("..")) {
                lblMessageFournisseur.setText("Email incorrecte");
            } else {
                try {
                    String code = null;
                    String tel = null;
                    code = SysGestBricoLocalClient.fou.AjouterFournisseur("", txtNomFournisseur.getText(), txtAdresselFournisseur.getText(), ser.dateJ);
                    if (code != null) {
                        tel = SysGestBricoLocalClient.tel.AjouterTelephoneFournisseur(code, txTelephoneFournisseur.getText(), txTelephoneFournisseur1.getText(), txtTelephoneFourni2.getText());
                        tel = SysGestBricoLocalClient.ema.AjouterEmailFournisseur(code, txtEmaillFournisseur.getText(), txEmailFournisseur1.getText(), txEmailFournisseur2.getText());
                        lblMessageFournisseur.setForeground(Color.green);
                        lblMessageFournisseur.setText("Fournisseur enregistre avec succes.Et voici son code " + code);
                        NettoyerFournisseur();
                        FournisseurComboTableau();
                        SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Fournisseur", "Ajout", code);
                        SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "TelephoneFournisseur", "Ajout", code);
                        SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "EmailFournisseur", "Ajout", code);

                    } else {
                        JOptionPane.showMessageDialog(null, "Prob " + code, "Information", JOptionPane.INFORMATION_MESSAGE);
                        // JOptionPane.showMessageDialog(null, "Enregistrement echoue!","Information", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (RemoteException ex) {
//            jLabel5.setBackground(Color.red);
//            jLabel5.setText("Le probleme de" + ex.getMessage());
                }
            }
        }
        //        if (txtnomfournisseur.getText().toString().trim().isEmpty() || txtadressefournisseur.getText().toString().trim().isEmpty() || txtemail4.getText().toString().trim().isEmpty()) {
        //            JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs.", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        //        } else {
        //            //            if(!txtnomfournisseur.getText().matches(Pattern.paternsNom)){
        //                //
        //                //              lblerreurnomf.setText("Nom fournisseur incorrect");
        //                //            } else if (!txttelephonefournisseur.getText().matches(Pattern.paternsTelephone)) {
        //                //
        //                //lblerreurtelephonef.setText("Le telephone est incorrecte");
        //                //}
        //            //else if(!txtemail4.getText().matches(Pattern.paternsemail)){
        //                //
        //                //
        //                //lblerreurmailf.setText("L'email est incorrecte");
        //                //}else if (txtemail4.getText().contains("..")){
        //                //lblerreurmailf.setText("L'email  est incorrecte");
        //                //            }else{
        //                try {
        //                    String retour = "";
        //                    retour = LancerClient.getF().AjouterFournisseur(txtcodefournisseur.getText().toString(), txtnomfournisseur.getText().toString(), cmbcategorie2.getSelectedItem().toString(), cmbnomarticle.getSelectedItem().toString(), txtadressefournisseur.getText().toString(), txttelephonefournisseur.getText().toString(), txtemail.getText().toString());
        //                    JOptionPane.showMessageDialog(null, retour, "Message d'information", JOptionPane.INFORMATION_MESSAGE);
        //                    cocof();
        //                    CodeAutomatiqueFournisseur.modifiercode(codef);
        //                    CodeAutomatiqueFournisseur.nettoyer();
        //                    txtnomfournisseur.setText("");
        //                    txtadressefournisseur.setText("");
        //                    txttelephonefournisseur.setText("");
        //                    txtemail4.setText("");
        //                    lblerreurmailf.setText("");
        //                    lblerreurtelephonef.setText("");
        //                    lblerreurnomf.setText("");
        //                } catch (RemoteException ex) {
        //                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        //                }
        //                //            }
        //        }

    }//GEN-LAST:event_btnajouterFournisseurActionPerformed

    private void txEmailFournisseur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEmailFournisseur2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txEmailFournisseur2ActionPerformed

    private void txEmailFournisseur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEmailFournisseur1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txEmailFournisseur1ActionPerformed

    private void txEmailFournisseur4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEmailFournisseur4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txEmailFournisseur4ActionPerformed

    private void txEmailFournisseur5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEmailFournisseur5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txEmailFournisseur5ActionPerformed

    private void btnSupprimerFournisseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerFournisseurActionPerformed
        // TODO add your handling code here:
//        String numero = cbxRechercherNumeroFournisseur.getSelectedItem().toString();
//        String message = "";
//        try {
//            
//            SysGestBricoLocalClient.tel.SupprimerTelephoneFournisseur(numero);
//            SysGestBricoLocalClient.ema.SupprimerEmailFournisseur(numero);
//            message = SysGestBricoLocalClient.fou.SuprimmerFournisseur(numero);
//            if (message != "") {
//                FournisseurComboTableau();
//                JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
//            }
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_btnSupprimerFournisseurActionPerformed

    private void txtPrixAchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrixAchatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrixAchatActionPerformed

    private void cbFournisseurAchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFournisseurAchatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFournisseurAchatActionPerformed

    private void btnenregistrerAchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenregistrerAchatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnenregistrerAchatActionPerformed

    private void txtPrixAchatRechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrixAchatRechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrixAchatRechActionPerformed

    private void cbFournisseurARechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFournisseurARechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFournisseurARechActionPerformed

    private void btnModifierAchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierAchatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModifierAchatActionPerformed

    private void btnSupprimerAchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerAchatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSupprimerAchatActionPerformed

    private void cbxLibelleArticleVenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLibelleArticleVenteActionPerformed
        //        comboarticle();
    }//GEN-LAST:event_cbxLibelleArticleVenteActionPerformed

    private void txEmailEmployeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEmailEmployeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txEmailEmployeActionPerformed

    private void txEmailEmploye1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEmailEmploye1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txEmailEmploye1ActionPerformed

    private void btnenregistrerEmployeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenregistrerEmployeActionPerformed
        // TODO add your handling code here:
        int quantiteemb = 0;
        int quantiteval = 0;
        if ("".equals(txtMatriculeEmploye.getText()) || "".equals(txtNomEmploye.getText()) || "".equals(txtPrenomEmploye.getText()) || "".equals(txtAdresseEmploye.getText())) {
            JOptionPane.showMessageDialog(null, "Saisir valeur manquante", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(txtTelephoneEmploye.getText()) || "".equals(txtTelephoneEmploye1.getText()) || "".equals(txEmailEmploye.getText()) || "".equals(txEmailEmploye1.getText())) {
            JOptionPane.showMessageDialog(null, "Saisir valeur manquante", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);

        } else {
            String trouve = null;
            String sal = null;
            String datenaissanceEmpl, dateembaucheEmpl;
            float salaire = 0;
            try {
//                SysGestBricoLocalClient.fon.RechercherQuantiteFonction(cbxFonctionEmploye.getSelectedItem().toString());
//                quantiteemb = SysGestBricoLocalClient.fon.prendreNumerofonction();
//                quantiteval = SysGestBricoLocalClient.fon.prendreNombreemploye();
//
//                if (quantiteval <= quantiteemb) {
//                    JOptionPane.showMessageDialog(null, "On a deja embauche la quantite d employe demande pour ce poste", "Information", JOptionPane.INFORMATION_MESSAGE);
//                } else {

                dateembaucheEmpl = cbxJourEmbaucheEmploye.getSelectedItem().toString() + "-" + cbxMoisEmbaucheEmploye.getSelectedItem().toString() + "-" + cbxAnneeEmbaucheEmploye.getSelectedItem().toString();
                salaire = Float.valueOf(cbxSalaireEmploye.getSelectedItem().toString());
                datenaissanceEmpl = cbxJourNaisEmploye.getSelectedItem().toString() + "-" + cbxMoisNaisEmploye.getSelectedItem().toString() + "-" + cbxAnneeNaisEmploye.getSelectedItem().toString();
                trouve = SysGestBricoLocalClient.emp.AjouterEmploye("", txtNomEmploye.getText(), txtPrenomEmploye.getText(), cbxSexeEmploye.getSelectedItem().toString(), txtMatriculeEmploye.getText(), datenaissanceEmpl, txtAdresseEmploye.getText(), dateembaucheEmpl, numerodepartement, cbxFonctionEmploye.getSelectedItem().toString());
                SysGestBricoLocalClient.tel.AjouterTelephoneEmploye(trouve, txtTelephoneEmploye.getText(), txtTelephoneEmploye1.getText(), null);
                SysGestBricoLocalClient.ema.AjouterEmailEmploye(trouve, txEmailEmploye.getText(), txEmailEmploye1.getText(), null);
                numeroEmploye = trouve;
                sal = SysGestBricoLocalClient.sal.AjouterSalaireEmploye(numeroEmploye, salaire);
                //JOptionPane.showMessageDialog(null, "Succes! le code est: " + trouve, "Enregistrement reussi", JOptionPane.INFORMATION_MESSAGE);
                lblMessageEmploye.setBackground(Color.yellow);
                lblMessageEmploye.setForeground(Color.blue);
                //lblMessageEmploye.setText("Succes! le code est: " + trouve);
                if (trouve != null && sal != null) {
                    numeroEmploye = trouve;

                    lblMessageEmploye.setText("Succes! le code est: " + numeroEmploye);
                    JOptionPane.showMessageDialog(null,"Succes! le code est: " + numeroEmploye,"Succes d'enregistrement Employe",1);


                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Employe", "Ajout", numerofournisseur);
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "TelephoneEmploye", "Ajout", numerofournisseur);
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "EmailEmploye", "Ajout", numerofournisseur);
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "SalaireEmploye", "Ajout", numerofournisseur);
                    NettoyerEmploye();
                    cbxRechercherEmploye.removeAllItems();
                    SysGestBricoLocalClient.chargerNumEmploye(cbxRechercherEmploye, jtChargerNumEmploye);


                } else {
                    lblMessageEmploye.setText("Echec d'enregistrement! Raison : " + trouve + "  " + sal);
                }
                // }

            } catch (Exception e) {
                //lblMessageEmploye.setText("Succes! le code est: " + trouve);
                JOptionPane.showMessageDialog(null, "Echec! Salopri a se: " + e.getMessage(), "Enregistrement Echoue", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnenregistrerEmployeActionPerformed

    private void txtEmailRechEmployeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailRechEmployeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailRechEmployeActionPerformed

    private void txtEmailRechEmploye1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailRechEmploye1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailRechEmploye1ActionPerformed

    private void btnSupprimerEmployeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerEmployeActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtMatriculeRechEmploye.getText()) || "".equals(txNomRechEmploye.getText()) || "".equals(txPrenomRechEmploye.getText()) || "".equals(txAdresseRechEmploye.getText())) {
            JOptionPane.showMessageDialog(null, "Vous devez avoir toutes les valeurs pour faire la suppression!", "Defaut de suppression", JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(txtTelephoneRechEmploye.getText()) || "".equals(txtTelephoneRechEmploye1.getText()) || "".equals(txtEmailRechEmploye.getText()) || "".equals(txtEmailRechEmploye1.getText())) {
            JOptionPane.showMessageDialog(null, "Vous devez avoir toutes les valeurs pour faire la suppression!", "Defaut de suppression", JOptionPane.ERROR_MESSAGE);

        } else {
            String trouve = null;
            String sal = null;
            String datenaissanceEmplmodification, dateembaucheEmplmodification;
            float salaire = 0;
            try {
                int rep = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer " + txNomRechEmploye.getText() + "?", "Demande Confirmation?", JOptionPane.YES_NO_OPTION);
                if (rep == JOptionPane.YES_OPTION) {
                    dateembaucheEmplmodification = cbxJourEmbaucheRechEmploye.getSelectedItem().toString() + "-" + cbxMoisEmbaucheEmploye.getSelectedItem().toString() + "-" + cbxAnneeEmbaucheEmploye.getSelectedItem().toString();
                    salaire = Float.valueOf(cbxSalaireRechEmploye.getSelectedItem().toString());
                    datenaissanceEmplmodification = cbxJourNaisRechEmploye.getSelectedItem().toString() + "-" + cbxMoisNaisEmploye.getSelectedItem().toString() + "-" + cbxAnneeNaisEmploye.getSelectedItem().toString();
                    //trouve = SysGestBricoLocalClient.emp.(numeroEmploye, txNomRechEmploye.getText(), txPrenomRechEmploye.getText(), cbSexeRechEmploye.getSelectedItem().toString(), txtMatriculeRechEmploye.getText(), datenaissanceEmplmodification, txAdresseRechEmploye.getText(), dateembaucheEmplmodification,numerodepartement, cbxFonctionRechEmploye.getSelectedItem().toString());
                    //SysGestBricoLocalClient.tel.ModifierTelephoneEmploye(numeroEmploye, txtTelephoneRechEmploye.getText(), txtTelephoneRechEmploye1.getText(), null);
                    //SysGestBricoLocalClient.ema.ModifierEmailEmploye(numeroEmploye, txtEmailRechEmploye.getText(), txtEmailRechEmploye1.getText(), null);
                    numeroEmploye = trouve;
                    // sal = SysGestBricoLocalClient.sal.ModifierSalaireEmploye(numeroEmploye, salaire);
                    //JOptionPane.showMessageDialog(null, "Succes! le code est: " + trouve, "Enregistrement reussi", JOptionPane.INFORMATION_MESSAGE);
                    lblMessageEmploye.setBackground(Color.yellow);
                    lblMessageEmploye.setForeground(Color.blue);
                }
                //lblMessageEmploye.setText("Succes! le code est: " + trouve);
                if (trouve == null && sal == null) {

                    //numeroEmploye = trouve;

                    lblMessageEmployeModifier.setText("Suppression non permise! " + txtNomUtilisateurConn.getText());
                    lblDateEmbauche.setText("Date embauche");
                    lblDateNais.setText("Date naissance");

                } else {
                    lblMessageEmployeModifier.setText("Echec d'enregistrement! Raison : " + trouve + "  " + sal);
                }
            } catch (Exception e) {
                //lblMessageEmploye.setText("Succes! le code est: " + trouve);
                JOptionPane.showMessageDialog(null, "Echec! Salopri a se: " + e.getMessage(), "Enregistrement Echoue", JOptionPane.ERROR_MESSAGE);
            }
        }
        int rep = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier " + txNomRechEmploye.getText() + "?", "Demande Confirmation?", JOptionPane.YES_NO_OPTION);
        if (rep == JOptionPane.YES_OPTION) {
        }
    }//GEN-LAST:event_btnSupprimerEmployeActionPerformed

    private void btnModifierEmployeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierEmployeActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtMatriculeRechEmploye.getText()) || "".equals(txNomRechEmploye.getText()) || "".equals(txPrenomRechEmploye.getText()) || "".equals(txAdresseRechEmploye.getText())) {
            JOptionPane.showMessageDialog(null, "Saisir valeur manquante", "Erreur de saisie modification", JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(txtTelephoneRechEmploye.getText()) || "".equals(txtTelephoneRechEmploye1.getText()) || "".equals(txtEmailRechEmploye.getText()) || "".equals(txtEmailRechEmploye1.getText())) {
            JOptionPane.showMessageDialog(null, "Saisir valeur manquante", "Erreur de saisie modification", JOptionPane.ERROR_MESSAGE);

        } else {
            String trouve = null;
            String sal = null;
            String datenaissanceEmplmodification, dateembaucheEmplmodification;
            float salaire = 0;
            try {
                int rep = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier " + txNomRechEmploye.getText() + "?", "Demande Confirmation?", JOptionPane.YES_NO_OPTION);
                if (rep == JOptionPane.YES_OPTION) {
                    dateembaucheEmplmodification = cbxJourEmbaucheRechEmploye.getSelectedItem().toString() + "-" + cbxMoisEmbaucheRechEmploye.getSelectedItem().toString() + "-" + cbxAnneeEmbaucheRechEmploye.getSelectedItem().toString();
                    salaire = Float.valueOf(cbxSalaireRechEmploye.getSelectedItem().toString());
                    datenaissanceEmplmodification = cbxJourNaisRechEmploye.getSelectedItem().toString() + "-" + cbxMoisNaisRechEmploye.getSelectedItem().toString() + "-" + cbxAnneeNaisRechEmploye.getSelectedItem().toString();
                    trouve = SysGestBricoLocalClient.emp.ModifierEmploye(numeroEmploye, txNomRechEmploye.getText(), txPrenomRechEmploye.getText(), cbSexeRechEmploye.getSelectedItem().toString(), txtMatriculeRechEmploye.getText(), datenaissanceEmplmodification, txAdresseRechEmploye.getText(), dateembaucheEmplmodification, numerodepartement, cbxFonctionRechEmploye.getSelectedItem().toString());
                    SysGestBricoLocalClient.tel.ModifierTelephoneEmploye(numeroEmploye, txtTelephoneRechEmploye.getText(), txtTelephoneRechEmploye1.getText(), null);
                    SysGestBricoLocalClient.ema.ModifierEmailEmploye(numeroEmploye, txtEmailRechEmploye.getText(), txtEmailRechEmploye1.getText(), null);
                    numeroEmploye = trouve;
                    sal = SysGestBricoLocalClient.sal.ModifierSalaireEmploye(numeroEmploye, salaire);
                    //JOptionPane.showMessageDialog(null, "Succes! le code est: " + trouve, "Enregistrement reussi", JOptionPane.INFORMATION_MESSAGE);
                    lblMessageEmploye.setBackground(Color.yellow);
                    lblMessageEmploye.setForeground(Color.blue);

                }
                //lblMessageEmploye.setText("Succes! le code est: " + trouve);
                if (trouve != null && sal != null) {
                    numeroEmploye = trouve;
                    lblMessageEmployeModifier.setText("Succes! " + trouve);
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Employe", "Modification", numeroEmploye);
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "TelephoneEmploye", "Modification", numeroEmploye);
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Email", "Modification", numeroEmploye);
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "SalaireEmploye", "Modification", numeroEmploye);
                    lblDateEmbauche.setText("Date embauche");
                    lblDateNais.setText("Date naissance");
                    NettoyerEmploye();


                } else {
                    lblMessageEmployeModifier.setText("Echec d'enregistrement! Raison : " + trouve + "  " + sal);
                }
            } catch (Exception e) {
                //lblMessageEmploye.setText("Succes! le code est: " + trouve);
                JOptionPane.showMessageDialog(null, "Echec Modification ! Salopri a se: " + e.getMessage(), "Enregistrement Echoue", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnModifierEmployeActionPerformed

    private void cbxRechercherNomFournisseurItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxRechercherNomFournisseurItemStateChanged
        // TODO add your handling code here:
        String rech = cbxRechercherNomFournisseur.getSelectedItem().toString();
        Boolean trouve = false;
        try {
            trouve = SysGestBricoLocalClient.fou.RechercherFournisseurParNom(rech);
            numerofournisseur = SysGestBricoLocalClient.fou.prendreNumerofournisseur();
            trouve = true;
            trouve = SysGestBricoLocalClient.tel.RechercherTelephoneFournisseur(numerofournisseur);
            trouve = SysGestBricoLocalClient.ema.RechercherEmailFournisseur(numerofournisseur);
            String nom = SysGestBricoLocalClient.fou.prendreNom();
            String adresse = SysGestBricoLocalClient.fou.prendreAdresse();
            String telephone = SysGestBricoLocalClient.tel.prendreTelephone();
            String telephone1 = SysGestBricoLocalClient.tel.prendreTelephone1();
            String telephone2 = SysGestBricoLocalClient.tel.prendreTelephone2();
            String email = SysGestBricoLocalClient.ema.prendreEmail();
            String email1 = SysGestBricoLocalClient.ema.prendreEmail1();
            String email2 = SysGestBricoLocalClient.ema.prendreEmail2();

            if (trouve) {
                txtNomFournisseur1.setText(nom);
                txAdresseFournisseur1.setText(adresse);
                txTelephoneFournisseur2.setText(telephone);
                txtTelephoneRechFourni1.setText(telephone1);
                txtTelephoneRechFourni2.setText(telephone2);
                txEmailFournisseur3.setText(email);
                txEmailFournisseur4.setText(email1);
                txEmailFournisseur5.setText(email2);
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Fournisseur", "Recherche", numerofournisseur);
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "EmailFournisseur", "Recherche", numerofournisseur);
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "TelephoneFournisseur", "Recherche", numerofournisseur);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxRechercherNomFournisseurItemStateChanged

    private void cbxRechercherNumeroFournisseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRechercherNumeroFournisseurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRechercherNumeroFournisseurActionPerformed

    private void cbxRechercherNumeroFournisseurItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxRechercherNumeroFournisseurItemStateChanged
        // TODO add your handling code here:
        String rech = cbxRechercherNumeroFournisseur.getSelectedItem().toString();
        Boolean trouve = false;
        try {
            trouve = SysGestBricoLocalClient.fou.RechercherFournisseurParNumero(rech);
            trouve = SysGestBricoLocalClient.tel.RechercherTelephoneFournisseur(rech);
            trouve = SysGestBricoLocalClient.ema.RechercherEmailFournisseur(rech);

            trouve = true;
            numerofournisseur = SysGestBricoLocalClient.fou.prendreNumerofournisseur();
            String nom = SysGestBricoLocalClient.fou.prendreNom();
            String adresse = SysGestBricoLocalClient.fou.prendreAdresse();
            String telephone = SysGestBricoLocalClient.tel.prendreTelephone();
            String telephone1 = SysGestBricoLocalClient.tel.prendreTelephone1();
            String telephone2 = SysGestBricoLocalClient.tel.prendreTelephone2();
            String email = SysGestBricoLocalClient.ema.prendreEmail();
            String email1 = SysGestBricoLocalClient.ema.prendreEmail1();
            String email2 = SysGestBricoLocalClient.ema.prendreEmail2();

            if (trouve) {
                txtNomFournisseur1.setText(nom);
                txAdresseFournisseur1.setText(adresse);
                txTelephoneFournisseur2.setText(telephone);
                txtTelephoneRechFourni1.setText(telephone1);
                txtTelephoneRechFourni2.setText(telephone2);
                txEmailFournisseur3.setText(email);
                txEmailFournisseur4.setText(email1);
                txEmailFournisseur5.setText(email2);
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Fournisseur", "Recherche", numerofournisseur);
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "EmailFournisseur", "Recherche", numerofournisseur);
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "TelephoneFournisseur", "Recherche", numerofournisseur);
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxRechercherNumeroFournisseurItemStateChanged

    private void btModifierFournisseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModifierFournisseurActionPerformed
        // String numero = cbxRechercherNumeroFournisseur.getSelectedItem().toString();
        if (txtNomFournisseur1.getText().equals("") || txAdresseFournisseur1.getText().equals("") || txTelephoneFournisseur2.getText().equals("") || txEmailFournisseur3.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Remplir les champs vides", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String message = "";
            try {
                int rep = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier ce fournisseur", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (rep == JOptionPane.YES_OPTION) {
                    SysGestBricoLocalClient.tel.ModifierTelephoneFournisseur(numerofournisseur, txTelephoneFournisseur2.getText(), txtTelephoneRechFourni1.getText(), txtTelephoneRechFourni2.getText());
                    SysGestBricoLocalClient.ema.ModifierEmailFournisseur(numerofournisseur, txEmailFournisseur3.getText(), txEmailFournisseur4.getText(), txEmailFournisseur5.getText());
                    message = SysGestBricoLocalClient.fou.ModifierFournisseur(numerofournisseur, txtNomFournisseur1.getText(), txAdresseFournisseur1.getText(), ser.dateJ);
                    if (message != "") {
                        FournisseurComboTableau();
                        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                        SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Fournisseur", "Modification", numerofournisseur);
                        SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "EmailFournisseur", "Modification", numerofournisseur);
                        SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "TelephoneFournisseur", "Modification", numerofournisseur);

                        NettoyerFournisseur();
                    } else {
                        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    NettoyerUtilisateur();
                }
            } catch (Exception e) {
                // JOptionPane.showMessageDialog(null, "Probleme modification: " + e.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        // TODO add your handling code here  NullPointerException
    }//GEN-LAST:event_btModifierFournisseurActionPerformed

    private void btAjouterCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAjouterCategorieActionPerformed
        if (txtCategorie.getText().equals("")) {
            LblMessageCategorie.setBackground(Color.red);
            LblMessageCategorie.setText("Entrer la categorie voulue");
        } else {
            try {
                String code = null;
                String code1 = null;
                code = SysGestBricoLocalClient.cat.AjouterCategorie("", txtCategorie.getText(), ser.date1);
                if (code != null) {
                    //SysGestBricoLocalClient.ListerCategorie(enteteCategorie, tbAfficherCategorie);
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "categorie", "Insertion", code);
                    // SysGestBricoLocalClient.uti.Tracabilite(Nomutilisateur, numerovente, code, numerovente, code, code, numerovente, numeroarticle)
                    CategorieComboTableau();
                    LblMessageCategorie.setText(code);
                }
            } catch (RemoteException ex) {
                LblMessageCategorie.setBackground(Color.red);
                LblMessageCategorie.setText("Le probleme de" + ex.getMessage());
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btAjouterCategorieActionPerformed
    public static String fonctionUtilisateur;
    public static String Nomutilisateur;
    public static String etatUtilisateur;
    public static String etatConnexion;
    public static String motPasseUtilisateur;
    public static String nommachine;
    public static String adressemachine;

    public void desactiverMenu() {

        mnEmploye.setVisible(false);
        mnUtilisateur.setVisible(false);
        MnVente.setVisible(false);
        mnAchat.setVisible(false);
        mnArticle.setVisible(false);
        mnCategorie.setVisible(false);
//        mnCommande.setVisible(false);
        mnFournisseur.setVisible(false);
        mnFournisseur.setVisible(false);
        mnPayroll.setVisible(false);
        mnOutil.setVisible(false);
        btnEmploye.setVisible(false);
        btnChagerMotPasseUt.setVisible(false);
        btnVente.setVisible(false);
        btnAchat.setVisible(false);
        btnArticle.setVisible(false);
        btnCategorie.setVisible(false);
        btnFournisseur.setVisible(false);
        btnPayroll.setVisible(false);
        btnOutil.setVisible(false);

    }

    private void btnConnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnecterActionPerformed
        // TODO add your handling code here:
        //CodeVente();
        //JOptionPane.showMessageDialog(null, "Prob " + numerovente, "Information", JOptionPane.INFORMATION_MESSAGE);

        try {
            if ("".equals(txtNomUtilisateurConn.getText()) || txtMotdemasseConn.getPassword().toString().isEmpty()) {
                // JOptionPane.showMessageDialog(this,"Aucun champs ne doit pas etre vide","Message Information",JOptionPane.INFORMATION_MESSAGE);  
                lblMessageConn.setBackground(Color.yellow);
                lblMessageConn.setForeground(Color.red);
                lblMessageConn.setText("Saisir nom utilisateur!");
                txtNomUtilisateurConn.setFocusable(true);
            } else if ("".equals(txtMotdemasseConn.getText().toString())) {
                // JOptionPane.showMessageDialog(this,"Aucun champs ne doit pas etre vide","Message Information",JOptionPane.INFORMATION_MESSAGE);  
                lblMessageConn.setBackground(Color.yellow);
                lblMessageConn.setForeground(Color.red);
                lblMessageConn.setText("Saisir mot de passe utilisateur!");
                txtNomUtilisateurConn.setFocusable(true);
             } else if (txtNomUtilisateurConn.getText() != "" && txtMotdemasseConn.getText() != "") {
                 Nomutilisateur = txtNomUtilisateurConn.getText();
                lblMessageConn.setBackground(Color.white);
                lblMessageConn.setForeground(Color.black);
                lblMessageConn.setText("");
                String us = txtNomUtilisateurConn.getText().trim();
                String pas = txtMotdemasseConn.getText().toString().trim();
                Nomutilisateur = us;
                boolean trouve = false;
                //Block important debut pour enlever commentaire
                try {

                    trouve = SysGestBricoLocalClient.uti.RechercherUtilisateur(us);
                    trouve = true;
                } catch (RemoteException ex) {
                    Logger.getLogger(SysGestBricoLocalClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (trouve == true) {
                    //JOptionPane.showMessageDialog(null, "Trouve " + SysGestBricoLocalClient.uti.prendreEtatutilisateur().toString());
                    etatConnexion = SysGestBricoLocalClient.uti.prendreEtatconnexion().toString();
                    etatUtilisateur = SysGestBricoLocalClient.uti.prendreEtatutilisateur().toString();
                    Nomutilisateur = SysGestBricoLocalClient.uti.prendreNomutilisateur().toString();
                    motPasseUtilisateur = SysGestBricoLocalClient.uti.prendreMotdepasse().toString();
                    fonctionUtilisateur = SysGestBricoLocalClient.uti.prendreRoleUtilisateur().toString();
                    nommachine = SysGestBricoLocalClient.uti.prendreNommachine().toString();
                    adressemachine = SysGestBricoLocalClient.uti.prendreAdressemachine().toString();
                    if (motPasseUtilisateur.equals(pas) && (Nomutilisateur.equals(us.trim()))) {
                        if ("Bloque".equals(etatUtilisateur)) {
                            JOptionPane.showMessageDialog(null, Nomutilisateur + " votre compte est bloque \nveillez contacter l administrateur", "Avertissement", JOptionPane.INFORMATION_MESSAGE);
                            Nomutilisateur = null;
                        } else {
                            if (etatConnexion.equals("Oui")) {
                                JOptionPane.showMessageDialog(null, Nomutilisateur + " votre compte est en train d utiliser\nsur la machine " + nommachine + " identifiee a l adresse suivante " + adressemachine + "\nVeillez deconnecter votre compte avant de connecter a nouveau", "Avertissement", JOptionPane.INFORMATION_MESSAGE);
                                Nomutilisateur = null;
                            } else {
                                SysGestBricoLocalClient.ModifierEtatConnexion(Nomutilisateur, "Oui");
                                if ("Administrateur".equals(fonctionUtilisateur)) {

                                    FrmPrincipal fn = new FrmPrincipal();
                                    this.dispose();
                                    fn.setSize(1100, 670);
                                    //fn.setSize(1200, 800);
                                    fn.remove(fn.panConnexion);
                                    fn.setLocationRelativeTo(null);
                                    fn.Achat.removeAll();
                                    fn.Article.removeAll();
                                    fn.Categorie.removeAll();
                                    //    fn.Commande.removeAll();
                                    fn.Employe.removeAll();
                                    fn.Fournisseur.removeAll();
                                    fn.Outils.removeAll();
                                    fn.Payroll.removeAll();
                                    fn.Vente.removeAll();
                                    TbArticle.setSelectedComponent(fn.Utilisateur);
                                    desactiverMenu();
                                    mnUtilisateur.setVisible(true);
                                    btnChagerMotPasseUt.setVisible(true);
                                     fn.lblUtilisateurconnecter.setText("Bienvenue " + Nomutilisateur);

                                    fn.setVisible(true);
                                } else if ("Directeur Administratif".equals(fonctionUtilisateur)) {
                                    try {
                                        FrmPrincipal fn = new FrmPrincipal();
                                        this.dispose();
                                        fn.setSize(1100, 670);
                                        //fn.setSize(1200, 800);
                                        fn.remove(fn.panConnexion);
                                        fn.setLocationRelativeTo(null);
                                        fn.Achat.removeAll();
                                        fn.Article.removeAll();
                                        fn.Categorie.removeAll();
                                        //  fn.Commande.removeAll();
                                        TbArticle.remove(0);//fournisseur  IllegalArgumentException
                                        TbArticle.remove(1);//
                                        TbArticle.remove(2);//fournisseur
                                        TbArticle.remove(3);
                                        fn.Fournisseur.removeAll();
                                        //fn.Outils.removeAll();
                                        fn.Payroll.removeAll();
                                        fn.Vente.removeAll();
                                        TbArticle.setSelectedComponent(fn.Employe);
                                        desactiverMenu();
                                        mnUtilisateur.setVisible(true);
                                        btnChagerMotPasseUt.setVisible(true);
                                        mnEmploye.setVisible(true);
                                        btnEmploye.setVisible(true);
                                        mnOutil.setVisible(true);
                                        btnOutil.setVisible(true);
                                        fn.PanRechercherUtilisateur.removeAll();
                                        fn.Utilisateur.remove(0);
                                        fn.Utilisateur.remove(1);
                                        fn.Utilisateur.remove(2);
                                         fn.lblUtilisateurconnecter.setText("Bienvenue " + Nomutilisateur);

                                        fn.setVisible(true);

                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                        System.exit(0);
                                    }

                                } else if ("Caissier".equals(fonctionUtilisateur)) {
                                    try {
                                        FrmPrincipal fn = new FrmPrincipal();
                                        this.dispose();
                                        fn.setSize(1100, 670);
                                        //fn.setSize(1200, 800);
                                        fn.remove(fn.panConnexion);
                                        fn.setLocationRelativeTo(null);
                                        fn.Achat.removeAll();
                                        fn.Article.removeAll();
                                        fn.Categorie.removeAll();
                                        //fn.Commande.removeAll();
                                        TbArticle.remove(0);//fournisseur  IllegalArgumentException
                                        TbArticle.remove(1);//
                                        //TbArticle.remove(2);//vente
                                        TbArticle.remove(3);
                                        fn.Fournisseur.removeAll();
                                        fn.Outils.removeAll();
                                        fn.Payroll.removeAll();
                                        fn.Employe.removeAll();
                                        TbArticle.setSelectedComponent(fn.Vente);
                                        desactiverMenu();
                                        mnUtilisateur.setVisible(true);
                                        btnChagerMotPasseUt.setVisible(true);
                                        MnVente.setVisible(true);
                                        btnVente.setVisible(true);
                                        //mnOutil.setVisible(true);
                                        fn.PanRechercherUtilisateur.removeAll();
                                        fn.Utilisateur.remove(0);
                                        fn.Utilisateur.remove(1);
                                        fn.Utilisateur.remove(2);
                                         fn.lblUtilisateurconnecter.setText("Bienvenue " + Nomutilisateur);
                                        fn.setVisible(true);

                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                        System.exit(0);
                                    }
                                } else if ("Directeur vente".equals(fonctionUtilisateur)) {
                                    try {
                                        FrmPrincipal fn = new FrmPrincipal();
                                        this.dispose();
                                        fn.setSize(1100, 670);
                                        //fn.setSize(1200, 800);
                                        fn.remove(fn.panConnexion);
                                        fn.setLocationRelativeTo(null);
                                        fn.Achat.removeAll();
                                        //fn.Article.removeAll();
                                        fn.Categorie.removeAll();
                                        //fn.Commande.removeAll();
                                        fn.Fournisseur.removeAll();
                                        fn.Outils.removeAll();
                                        fn.Payroll.removeAll();
                                        fn.Employe.removeAll();
                                        TbArticle.setSelectedComponent(fn.Article);
                                        desactiverMenu();
                                        mnUtilisateur.setVisible(true);
                                        btnChagerMotPasseUt.setVisible(true);
                                        MnVente.setVisible(true);
                                        btnVente.setVisible(true);
                                        mnArticle.setVisible(true);
                                        btnArticle.setVisible(true);
                                        mnPayroll.setVisible(false);
                                        //mnOutil.setVisible(true);
                                        fn.PanRechercherUtilisateur.removeAll();
                                        fn.Utilisateur.remove(0);
                                        fn.Utilisateur.remove(1);
                                        fn.Utilisateur.remove(2);
                                         fn.lblUtilisateurconnecter.setText("Bienvenue " + Nomutilisateur);

                                        fn.setVisible(true);

                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                        System.exit(0);
                                    }

                                } else if ("Directeur Achat".equals(fonctionUtilisateur)) {
                                    try {
                                        FrmPrincipal fn = new FrmPrincipal();
                                        this.dispose();
                                        fn.setSize(1100, 670);
                                        //fn.setSize(1200, 800);
                                        fn.remove(fn.panConnexion);
                                        fn.setLocationRelativeTo(null);
                                        fn.Vente.removeAll();
                                        fn.Article.removeAll();
                                        // fn.Categorie.removeAll();
                                        //fn.Commande.removeAll();
                                        fn.Outils.removeAll();
                                        fn.Payroll.removeAll();
                                        fn.Employe.removeAll();
                                        TbArticle.setSelectedComponent(fn.Achat);
                                        desactiverMenu();
                                        mnUtilisateur.setVisible(true);
                                        btnChagerMotPasseUt.setVisible(true);
                                        mnAchat.setVisible(true);
                                        btnAchat.setVisible(true);
                                        mnFournisseur.setVisible(true);
                                        btnFournisseur.setVisible(true);
                                        mnCategorie.setVisible(false);
                                        //mnOutil.setVisible(true);
                                        fn.PanRechercherUtilisateur.removeAll();
                                        fn.Utilisateur.remove(0);
                                        fn.Utilisateur.remove(1);
                                        fn.Utilisateur.remove(2);
                                         fn.lblUtilisateurconnecter.setText("Bienvenue " + Nomutilisateur);

                                        fn.setVisible(true);

                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                        System.exit(0);
                                    }
                                } else if ("Comptable".equals(fonctionUtilisateur)) {
                                    try {
                                        FrmPrincipal fn = new FrmPrincipal();
                                        this.dispose();
                                        fn.setSize(1100, 670);
                                        //fn.setSize(1200, 800);
                                        fn.remove(fn.panConnexion);
                                        fn.setLocationRelativeTo(null);
                                        fn.Vente.removeAll();
                                        fn.Article.removeAll();
                                        fn.Categorie.removeAll();
                                        //fn.Commande.removeAll();
                                        fn.Fournisseur.removeAll();
                                        fn.Outils.removeAll();
                                        fn.Achat.removeAll();
                                        fn.Employe.removeAll();
                                        TbArticle.setSelectedComponent(fn.Payroll);
                                        desactiverMenu();
                                        mnUtilisateur.setVisible(true);
                                        btnChagerMotPasseUt.setVisible(true);
                                        mnPayroll.setVisible(true);
                                        btnPayroll.setVisible(true);
                                        fn.PanRechercherUtilisateur.removeAll();
                                        fn.Utilisateur.remove(0);
                                        fn.Utilisateur.remove(1);
                                        fn.Utilisateur.remove(2);
                                         fn.lblUtilisateurconnecter.setText("Bienvenue " + Nomutilisateur);

                                        fn.setVisible(true);

                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                        System.exit(0);
                                    }
                                } else {
                                    lblMessageConn.setBackground(Color.yellow);
                                    lblMessageConn.setForeground(Color.red);
                                    JOptionPane.showMessageDialog(this, "Bonjour\n" + txtNomUtilisateurConn.getText() + ",vous n'avez aucun droit d'acces!", "Erreur d'acces", JOptionPane.INFORMATION_MESSAGE);
                                    Nomutilisateur = null;
                                    txtNomUtilisateurConn.setText("");
                                    txtMotdemasseConn.setText("");
                                }
                            }
                        }
                    } else {
                        lblMessageConn.setBackground(Color.yellow);
                        lblMessageConn.setForeground(Color.red);
                        Nomutilisateur = null;
                        lblMessageConn.setText("Nom Utilisateur ou mot de passe incorrect!");
                    }
                }
            }
        } catch (Exception e) {
            lblMessageConn.setBackground(Color.yellow);
            lblMessageConn.setForeground(Color.red);
            Nomutilisateur = null;
            lblMessageConn.setText("Refus de droit d'acces!");
        }

    }//GEN-LAST:event_btnConnecterActionPerformed

    private void btnQuitterConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitterConnexionActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnQuitterConnexionActionPerformed

    private void txtNomUtilisateurConnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomUtilisateurConnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomUtilisateurConnActionPerformed

    private void mnUtilisateurMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnUtilisateurMouseMoved
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Utilisateur);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnUtil" + e.getMessage());
        }
    }//GEN-LAST:event_mnUtilisateurMouseMoved

    private void mnEmployeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnEmployeMouseMoved
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Employe);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnEmp" + e.getMessage());
        }

    }//GEN-LAST:event_mnEmployeMouseMoved

    private void mnOutilMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnOutilMouseMoved
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Outils);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnOutil" + e.getMessage());
        }
    }//GEN-LAST:event_mnOutilMouseMoved

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
// int rep = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier ce fournisseur", "Confirmation", JOptionPane.YES_NO_OPTION);
//    if (rep == JOptionPane.YES_OPTION) {
        try {
            
            if (Nomutilisateur != null) {
                SysGestBricoLocalClient.ModifierEtatConnexion(Nomutilisateur, "Non");
                JOptionPane.showMessageDialog(null, "Votre compte etait ouvert,SysGesBricoLocal Vient le fermer pour vous " + Nomutilisateur + "!\nCliquer Sur OK ou Pressez la touche Entrer de votre Clavier!\nMerci et Au revoir.", "Fermeture SysgesBricoLocal en cours...", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
//        this.dispose();
//        SysGestBricoLocalClient.demarrer();
    }//GEN-LAST:event_formWindowClosed

    private void MnVenteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnVenteMouseMoved
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Vente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnVente" + e.getMessage());
        }
    }//GEN-LAST:event_MnVenteMouseMoved

    private void mnPayrollMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnPayrollMouseMoved
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Payroll);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnPayroll" + e.getMessage());
        }
    }//GEN-LAST:event_mnPayrollMouseMoved

    private void mnFournisseurMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnFournisseurMouseMoved
        // TODO add your handling code here:
        try {
            Fournisseur.setSelectedIndex(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnFour " + e.getMessage());
        }
    }//GEN-LAST:event_mnFournisseurMouseMoved

    private void mnCategorieMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnCategorieMouseMoved
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Categorie);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnCategorie " + e.getMessage());
        }
    }//GEN-LAST:event_mnCategorieMouseMoved

    private void mnAchatMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnAchatMouseMoved
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Achat);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnAchat" + e.getMessage());
        }
    }//GEN-LAST:event_mnAchatMouseMoved

    private void cbRechercherDescCategorieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRechercherDescCategorieItemStateChanged
        String rech = cbRechercherDescCategorie.getSelectedItem().toString();
        Boolean trouve = false;
        try {
            trouve = SysGestBricoLocalClient.cat.RechercherCategorie(rech);
            trouve = true;
            String numero = SysGestBricoLocalClient.cat.prendreNumerocategorie();
            String categorie = SysGestBricoLocalClient.cat.prendreDescription();
            if (trouve) {
                txtCategorieRechercher.setText(categorie);
                txtNumeroCategorieRechercher.setText(numero);
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbRechercherDescCategorieItemStateChanged

    private void cbRechercherDateAjoutCAtegorieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRechercherDateAjoutCAtegorieItemStateChanged
        String rech = cbRechercherDateAjoutCAtegorie.getSelectedItem().toString();
        Boolean trouve = false;
        try {
            trouve = SysGestBricoLocalClient.cat.RechercherCategorie(rech);
            trouve = true;
            String numero = SysGestBricoLocalClient.cat.prendreNumerocategorie();
            String categorie = SysGestBricoLocalClient.cat.prendreDescription();
            if (trouve) {
                txtCategorieRechercher.setText(categorie);
                txtNumeroCategorieRechercher.setText(numero);
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "categorie", "Recherche", numero);
            }
        } catch (Exception e) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbRechercherDateAjoutCAtegorieItemStateChanged

    private void btSupprimerCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSupprimerCategorieActionPerformed
        // TODO add your handling code here:
        String numero = txtNumeroCategorieRechercher.getText();
        String message = "";
        try {
            int rep = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment Supprimer", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                message = SysGestBricoLocalClient.cat.SuprimmerCategorie(numero);
                if (message != "") {
                    CategorieComboTableau();
                    JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                    txtCategorieRechercher.setText("");
                    txtNumeroCategorieRechercher.setText("");
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "categorie", "Suppression", numero);
                }
            } else {
                txtCategorieRechercher.setText("");
                txtNumeroCategorieRechercher.setText("");

            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btSupprimerCategorieActionPerformed

    private void btModifierCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModifierCategorieActionPerformed
        if (txtCategorieRechercher.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Entrer la categorie a modifier", "Avertissement", JOptionPane.WARNING_MESSAGE);
        } else {
            String numero = txtNumeroCategorieRechercher.getText();
            String message = "";
            try {
                int rep = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier cette categorie", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (rep == JOptionPane.YES_OPTION) {
                    message = SysGestBricoLocalClient.cat.ModifierCategorie(numero, txtCategorieRechercher.getText());
                    if (message != "") {
                        CategorieComboTableau();
                        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                        SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "categorie", "Modification", numero);
                        txtCategorieRechercher.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    txtCategorieRechercher.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Probleme modification: " + e.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btModifierCategorieActionPerformed

    private void cbFournisseurAjouterArticleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFournisseurAjouterArticleItemStateChanged
        // TODO add your handling code here:
        String rech = cbFournisseurAjouterArticle.getSelectedItem().toString();
        Boolean trouve = false;
        try {
            trouve = SysGestBricoLocalClient.fou.RechercherFournisseurParNom(rech);

            trouve = true;
            String numero = SysGestBricoLocalClient.fou.prendreNumerofournisseur();
            if (trouve) {
                numerofournisseurArticle = numero;
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_cbFournisseurAjouterArticleItemStateChanged

    private void BtAjouterArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjouterArticleActionPerformed
        // TODO add your handling code here:
        if (txtPrixArticle.getText().equals("") || txtQuantiteArticle.getText().equals("") || txtDescriptionArticle.getText().equals("") || CbCategorieAjouterArticle.getSelectedItem().toString().equals("") || cbFournisseurAjouterArticle.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Remplir les champs vides", "Avertissement", JOptionPane.WARNING_MESSAGE);
        } else {
            float prixarticle = 0;
            int qt = 0;
            try {
                try {
                    prixarticle = Float.valueOf(txtPrixArticle.getText());
                    qt = Integer.valueOf(txtQuantiteArticle.getText());
                    if (prixarticle <= 0 || qt <= 0) {
                        JOptionPane.showMessageDialog(null, "Vous devez entrer un nombre superieur a zero", "Information", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String code = null;
                        String code1 = null;


                        code = SysGestBricoLocalClient.art.AjouterArticle(numerofournisseurArticle, "", txtDescriptionArticle.getText(), CbCategorieAjouterArticle.getSelectedItem().toString(), prixarticle);
                        if (code != null) {
                            //CodeStock();
                            numeroarticle = code;
                            code1 = SysGestBricoLocalClient.sto.AjouterStock("", numeroarticle, ser.dateJ, qt);
                            // SysGestBricoLocalClient.ListerArticle(entetearticle, tbArticleAjouter);

                            JOptionPane.showMessageDialog(null, "Article enregistre et voici son code" + code, "Information", JOptionPane.INFORMATION_MESSAGE);
                            SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Article", "Ajout", code);
                            SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Stock", "Ajout", code);
                            txtPrixArticle.setText("");
                            txtQuantiteArticle.setText("");
                            txtDescriptionArticle.setText("");
                        }
                    }
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Vous devez entrer un nombre", "Information", JOptionPane.ERROR_MESSAGE);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BtAjouterArticleActionPerformed

    private void cbRechercherDescriptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRechercherDescriptionItemStateChanged
        // TODO add your handling code here:
        String rech = cbRechercherDescription.getSelectedItem().toString();
        Boolean trouve = false;
        try {
            SysGestBricoLocalClient.RechercherArticle(rech, entetearticlerechercher, tbArticleRechercher);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbRechercherDescriptionItemStateChanged

    private void cbRechercherDateAjoutItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRechercherDateAjoutItemStateChanged
        // TODO add your handling code here:
        String rech = cbRechercherDateAjout.getSelectedItem().toString();
        Boolean trouve = false;
        try {
            SysGestBricoLocalClient.RechercherArticle(rech, entetearticlerechercher, tbArticleRechercher);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbRechercherDateAjoutItemStateChanged

    private void cbRecherchersupprimerNumeroArtItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRecherchersupprimerNumeroArtItemStateChanged
        // TODO add your handling code here:
        String rech = cbRecherchersupprimerNumeroArt.getSelectedItem().toString();
        Boolean trouve = false;
        String numfournisseur = "";
        try {
            trouve = SysGestBricoLocalClient.art.RechercherArticleModifier(rech);
            SysGestBricoLocalClient.sto.RechercherStock(rech);
            //trouve = SysGestBricoLocalClient.fou.RechercherFournisseurParNom(rech);
            // trouve = SysGestBricoLocalClient.ema.RechercherEmailFournisseur(rech);

            trouve = true;
            numeroarticle = SysGestBricoLocalClient.art.prendreNumeroarticle();
            String libelle = SysGestBricoLocalClient.art.prendreLibelle();
            String categorie = SysGestBricoLocalClient.art.prendreCategorie();
            numfournisseur = SysGestBricoLocalClient.art.prendreNumerofournisseur();
            Float prix = SysGestBricoLocalClient.art.prendrePrixarticle();
            String quantite = String.valueOf(SysGestBricoLocalClient.sto.prendreQuantite());


            if (trouve) {


                txtDescriptionArticleSupprimer.setText(libelle);
                txCategorieArticleSupprimer.setText(categorie);
                txPrixArticleSupprimer.setText(prix.toString());
                txQuantiteArticleSupprimer.setText(quantite);
                SysGestBricoLocalClient.fou.RechercherFournisseurParNumero(numfournisseur);
                String nomfour = SysGestBricoLocalClient.fou.prendreNom();
                txFournisseurArticleSupprimer.setText(nomfour);

            }

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null,e.getMessage()+numfournisseur , "Information", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cbRecherchersupprimerNumeroArtItemStateChanged

    private void BtSupprimerArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSupprimerArticleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtSupprimerArticleActionPerformed

    private void BtModifierArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierArticleActionPerformed
        // TODO add your handling code here:
        if (txPrixArticleModifier.getText().equals("") || txQuantiteArticleModifier.getText().equals("") || txtDescriptionArticleModifier.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Remplir les champs vides", "Avertissement", JOptionPane.WARNING_MESSAGE);
        } else {
            float prixarticle = 0;
            int qt = 0;
            try {
                try {
                    prixarticle = Float.valueOf(txPrixArticleModifier.getText());
                    qt = Integer.valueOf(txQuantiteArticleModifier.getText());
                    if (prixarticle <= 0 || qt <= 0) {
                        JOptionPane.showMessageDialog(null, "Vous devez entrer un nombre superieur a zero", "Information", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int rep = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier cet article", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (rep == JOptionPane.YES_OPTION) {
                            String code = null;
                            code = SysGestBricoLocalClient.art.ModifierArticle(numerofournisseurArticleMod, numeroarticle, txtDescriptionArticleModifier.getText(), CbCategorieArticleModifier.getSelectedItem().toString(), prixarticle);
                            if (code != null) {
                                SysGestBricoLocalClient.sto.ModifierStockA(numeroarticle, qt);
                                ArticleComboTableau();
                                JOptionPane.showMessageDialog(null, code + numeroarticle + numerofournisseurArticleMod, "Information", JOptionPane.INFORMATION_MESSAGE);
                                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Article", "Modification", numeroarticle);
                                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Stock", "Modification", numeroarticle);
                                txPrixArticleModifier.setText("");
                                txQuantiteArticleModifier.setText("");
                                txtDescriptionArticleModifier.setText("");
                            }
                        } else {
                            txPrixArticleModifier.setText("");
                            txQuantiteArticleModifier.setText("");
                            txtDescriptionArticleModifier.setText("");
                        }
                    }
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Vous devez entrer un nombre", "Information", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BtModifierArticleActionPerformed

    private void cbFournisseurSupprimer1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFournisseurSupprimer1ItemStateChanged
        // TODO add your handling code here:
        String rech = cbFournisseurSupprimer1.getSelectedItem().toString();
        Boolean trouve = false;
        try {
            trouve = SysGestBricoLocalClient.fou.RechercherFournisseurParNom(rech);
            trouve = true;
            numerofournisseurArticleMod = SysGestBricoLocalClient.fou.prendreNumerofournisseur();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbFournisseurSupprimer1ItemStateChanged

    private void cbDescriptionArticleModifierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDescriptionArticleModifierItemStateChanged
        // TODO add your handling code here:
        String rech = cbDescriptionArticleModifier.getSelectedItem().toString();
        Boolean trouve = false;
        String numfournisseur = "";
        try {
            trouve = SysGestBricoLocalClient.art.RechercherArticleModifier(rech);
            SysGestBricoLocalClient.sto.RechercherStock(rech);
            trouve = true;
            numeroarticle = SysGestBricoLocalClient.art.prendreNumeroarticle();
            String libelle = SysGestBricoLocalClient.art.prendreLibelle();
            String categorie = SysGestBricoLocalClient.art.prendreCategorie();
            numfournisseur = SysGestBricoLocalClient.art.prendreNumerofournisseur();
            Float prix = SysGestBricoLocalClient.art.prendrePrixarticle();
            String quantite = String.valueOf(SysGestBricoLocalClient.sto.prendreQuantite());
            numerofournisseurArticleMod = numfournisseur;
            if (trouve) {
                txtDescriptionArticleModifier.setText(libelle);
                CbCategorieArticleModifier.removeAll();
                CbCategorieArticleModifier.addItem(categorie);
                SysGestBricoLocalClient.chargerCategorieArticle(CbCategorieArticleModifier, jtChargerCategorie);
                txPrixArticleModifier.setText(prix.toString());
                txQuantiteArticleModifier.setText(quantite);
                SysGestBricoLocalClient.fou.RechercherFournisseurParNumero(numfournisseur);
                String nomfour = SysGestBricoLocalClient.fou.prendreNom();
                cbFournisseurSupprimer1.removeAll();
                cbFournisseurSupprimer1.addItem(nomfour);
                SysGestBricoLocalClient.chargerfournisseurArticle(cbFournisseurSupprimer1, jtChargerFournisseur);
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Article", "Recherche", numeroarticle);
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Stock", "Recherche", numeroarticle);

            }

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null,e.getMessage()+numfournisseur , "Information", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cbDescriptionArticleModifierItemStateChanged

    private void btnEnregistrerFonction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerFonction1ActionPerformed
        // TODO add your handling code here:
        int quantiteemploye = 0;
        float salmin = 0;
        float salmax = 0;
        try {
            quantiteemploye = Integer.valueOf(txtQuantiteEmploye.getText());
            salmin = Float.valueOf(txtSalairemin.getText());
            salmax = Float.valueOf(txtSalairemax.getText());
            try {
                if (quantiteemploye <= 0) {
                    JOptionPane.showMessageDialog(null, "Une fonction doit avoir au moins un employe", "Information", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (salmin >= salmax) {
                        JOptionPane.showMessageDialog(null, "Salaire maximum invalide", "Information", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String code = null;

                        code = SysGestBricoLocalClient.fon.AjouterFonction(0, txtFonction1.getText(), quantiteemploye);
                        if (code != null) {
                            SysGestBricoLocalClient.gri.AjouterGrilleSalariale(txtFonction1.getText(), salmin, salmax);
                            JOptionPane.showMessageDialog(null, "Fonction " + txtFonction1.getText() + " enregistree avec succes", "Information", JOptionPane.INFORMATION_MESSAGE);
                            SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Fonction", "Ajout", numeroarticle);
                            SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "GrilleSalariale", "Ajout", numeroarticle);

                            txtQuantiteEmploye.setText("");
                            txtSalairemin.setText("");
                            txtSalairemax.setText("");
                            txtFonction1.setText("");
                            FonctionComboTableau();
                        }
                    }
                }
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vous devez entrer un nombre", "Information", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEnregistrerFonction1ActionPerformed

    private void btnModifierFonction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierFonction1ActionPerformed
        // TODO add your handling code here:
        int quantiteemploye = 0;
        float salmin = 0;
        float salmax = 0;
        try {
            quantiteemploye = Integer.valueOf(txtQuantiteEmployeMod1.getText());
            salmin = Float.valueOf(txtSalairemin3.getText());
            salmax = Float.valueOf(txtSalairemax3.getText());
            try {
                if (quantiteemploye <= 0) {
                    JOptionPane.showMessageDialog(null, "Une fonction doit avoir au moins un employe", "Information", JOptionPane.ERROR_MESSAGE);
                } else {
                    String code = null;
                    if (salmin >= salmax) {
                        JOptionPane.showMessageDialog(null, "Salaire maximum invalide", "Information", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int rep = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (rep == JOptionPane.YES_OPTION) {

                            code = SysGestBricoLocalClient.fon.ModifierFonction(cbFonctionMod1.getSelectedItem().toString(), quantiteemploye, numerofonction);
                            if (code != null) {
                                SysGestBricoLocalClient.gri.ModifierGrilleSalariale(cbFonctionMod1.getSelectedItem().toString(), salmin, salmax);
                                JOptionPane.showMessageDialog(null, code, "Information", JOptionPane.INFORMATION_MESSAGE);
                                FonctionComboTableau();
                                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Fonction", "Modification", numeroarticle);
                                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "GrilleSalariale", "Modification", numeroarticle);
                            }
                        }
                    }
                }
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vous devez entrer un nombre", "Information", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModifierFonction1ActionPerformed

    private void cbFonctionMod1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFonctionMod1ItemStateChanged
        // TODO add your handling code here:
        String rech = cbFonctionMod1.getSelectedItem().toString();
        Boolean trouve = false;
        String nombreemp = "";
        String salmin = "";
        String salmax = "";
        try {
            trouve = SysGestBricoLocalClient.fon.RechercherFonctionModifier(rech);
            SysGestBricoLocalClient.gri.RechercherGrilleSalariale(rech);
            trouve = true;
            int nombreemploye = SysGestBricoLocalClient.fon.prendreNombreemploye();
            float salairemin = SysGestBricoLocalClient.gri.prendreSalaireminimal();
            float salairemax = SysGestBricoLocalClient.gri.prendreSalairemaximal();
            salmax = String.valueOf(salairemax);
            salmin = String.valueOf(salairemin);
            nombreemp = String.valueOf(nombreemploye);
            if (trouve) {
                txtQuantiteEmployeMod1.setText(nombreemp);
                txtSalairemax3.setText(salmax);
                txtSalairemin3.setText(salmin);
                numerofonction = SysGestBricoLocalClient.fon.prendreNumerofonction();
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Fonction", "Recherche", numeroarticle);
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "GrilleSalariale", "Recherche", numeroarticle);



            }

        } catch (Exception e) {
            //  JOptionPane.showMessageDialog(null,e.getMessage()+numfournisseur , "Information", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cbFonctionMod1ItemStateChanged

    private void btnSupprimerFonction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerFonction1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSupprimerFonction1ActionPerformed

    private void txtSalaireminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaireminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaireminActionPerformed

    private void txtSalairemaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalairemaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalairemaxActionPerformed

    private void txtSalairemax3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalairemax3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalairemax3ActionPerformed

    private void txtSalairemin3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalairemin3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalairemin3ActionPerformed

    private void btnAjouterDepartementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterDepartementActionPerformed
        // TODO add your handling code here:
        try {
            String code = null;
            code = SysGestBricoLocalClient.dep.AjouterDepartement("", txtAjouterDepartement.getText().trim());
            if (code != null) {
                cbxModifierDepartement.removeAll();
                cbxModifierDepartement.addItem("Choisir Departement");
                SysGestBricoLocalClient.chargerDepartement(cbxModifierDepartement, jtChargerFournisseur);
                JOptionPane.showMessageDialog(null, code, "Information", JOptionPane.INFORMATION_MESSAGE);
                txtAjouterDepartement.setText("");
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Departement", "Ajout", numeroarticle);
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAjouterDepartementActionPerformed

    private void btnModifierDepartementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierDepartementActionPerformed
        // TODO add your handling code here:
        try {
            String code = null;
            int rep = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                code = SysGestBricoLocalClient.dep.ModifierDepartement(numerodepartement, txtModifierDepartement.getText().trim());
                if (code != null) {
                    cbxModifierDepartement.removeAll();
                    cbxModifierDepartement.addItem("Choisir Departement");
                    SysGestBricoLocalClient.chargerDepartement(cbxModifierDepartement, jtChargerFournisseur);
                    JOptionPane.showMessageDialog(null, code + numerodepartement, "Information", JOptionPane.INFORMATION_MESSAGE);
                    txtModifierDepartement.setText("");
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Departement", "Modification", numeroarticle);
                }

            } else {
                txtModifierDepartement.setText("");
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnModifierDepartementActionPerformed

    private void btnSupprimerDepartementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerDepartementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSupprimerDepartementActionPerformed

    private void OutilsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutilsMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_OutilsMouseMoved

    private void OutilsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutilsMouseClicked
        // TODO add your handling code here:
        cbxModifierDepartement.removeAll();
        cbxModifierDepartement.addItem("Choisir Departement");
        SysGestBricoLocalClient.chargerDepartement(cbxModifierDepartement, jtChargerFournisseur);
    }//GEN-LAST:event_OutilsMouseClicked

    private void cbxModifierDepartementItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxModifierDepartementItemStateChanged
        // TODO add your handling code here:
        String rech = cbxModifierDepartement.getSelectedItem().toString();
        Boolean trouve = false;
        String nombreemp = "";
        try {
            trouve = SysGestBricoLocalClient.dep.RechercherDepartement(rech);
            trouve = true;


            if (trouve) {
                numerodepartement = SysGestBricoLocalClient.dep.prendreNumerodepartement();
                txtModifierDepartement.setText(cbxModifierDepartement.getSelectedItem().toString());
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Departement", "Recherche", numeroarticle);
                //  JOptionPane.showMessageDialog(null, trouve + " Start " + numerodepartement, "Selection departement", JOptionPane.INFORMATION_MESSAGE);


            }

        } catch (Exception e) {
            //  JOptionPane.showMessageDialog(null,e.getMessage()+numfournisseur , "Information", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_cbxModifierDepartementItemStateChanged

    private void btnModifierTaxeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierTaxeActionPerformed
        // TODO add your handling code here:
        float tca = 0;
        float ona = 0;
        float sante = 0;
        float vie = 0;
        float mort = 0;
        try {
            tca = Float.valueOf(txtTca.getText());
            ona = Float.valueOf(txtOna.getText());
            sante = Float.valueOf(txtSante.getText());
            vie = Float.valueOf(txtVie.getText());
            mort = Float.valueOf(txtMort.getText());
            String code = null;
            if ((tca < 0 || tca > 30) || (ona < 0 || ona > 30) || (sante < 0 || sante > 30) || (vie < 0 || vie > 30) || (mort < 0 || mort > 30)) {
                JOptionPane.showMessageDialog(null, "Taxe doit etre compris entre 0 et 30 %", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                code = SysGestBricoLocalClient.pre.ModifierPrelevement(tca, ona, sante, vie, mort);
                if (code != null) {

                    JOptionPane.showMessageDialog(null, code, "Information", JOptionPane.INFORMATION_MESSAGE);
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Prelevement", "Modification", numeroarticle);
                }
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Entrer un nombre", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnModifierTaxeActionPerformed

    private void cbxFonctionEmployeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFonctionEmployeItemStateChanged
        // TODO add your handling code here:
        String rech = cbxFonctionEmploye.getSelectedItem().toString();
        Boolean trouve = false;

        try {
            trouve = SysGestBricoLocalClient.fon.RechercherFonctionModifier(rech);
            SysGestBricoLocalClient.gri.RechercherGrilleSalariale(rech);
            trouve = true;
            int nombreemploye = SysGestBricoLocalClient.fon.prendreNombreemploye();
            float salairemin = SysGestBricoLocalClient.gri.prendreSalaireminimal();
            float salairemax = SysGestBricoLocalClient.gri.prendreSalairemaximal();

            if (trouve) {
                cbxSalaireEmploye.removeAllItems();
                cbxSalaireEmploye.addItem(salairemin);
                cbxSalaireEmploye.addItem(salairemax);
                numerofonction = SysGestBricoLocalClient.fon.prendreNumerofonction();

                //  JOptionPane.showMessageDialog(null, numerofonction, "Information", JOptionPane.ERROR_MESSAGE);

            }

        } catch (Exception e) {
            //  JOptionPane.showMessageDialog(null,e.getMessage()+numfournisseur , "Information", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cbxFonctionEmployeItemStateChanged

    private void cbxAffectationEmployeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAffectationEmployeItemStateChanged
        // TODO add your handling code here:
        String rech = cbxAffectationEmploye.getSelectedItem().toString();
        Boolean trouve = false;
        String nombreemp = "";

        try {
            trouve = SysGestBricoLocalClient.dep.RechercherDepartement(rech);

            trouve = true;
            if (trouve == true) {
                numerodepartement = SysGestBricoLocalClient.dep.prendreNumerodepartement();
                //JOptionPane.showMessageDialog(null, trouve + " Start " + numerodepartement, "Selection departement", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            //  JOptionPane.showMessageDialog(null,e.getMessage()+numfournisseur , "Information", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cbxAffectationEmployeItemStateChanged

    private void cbxFonctionRechEmployeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFonctionRechEmployeItemStateChanged
        // TODO add your handling code here:
        String rech = cbxFonctionRechEmploye.getSelectedItem().toString();
        Boolean trouve = false;

        try {
            trouve = SysGestBricoLocalClient.fon.RechercherFonctionModifier(rech);
            SysGestBricoLocalClient.gri.RechercherGrilleSalariale(rech);
            trouve = true;
            int nombreemploye = SysGestBricoLocalClient.fon.prendreNombreemploye();
            float salairemin = SysGestBricoLocalClient.gri.prendreSalaireminimal();
            float salairemax = SysGestBricoLocalClient.gri.prendreSalairemaximal();

            if (trouve) {
                cbxSalaireRechEmploye.removeAllItems();
                cbxSalaireRechEmploye.addItem(salairemin);
                cbxSalaireRechEmploye.addItem(salairemax);
                numerofonction = SysGestBricoLocalClient.fon.prendreNumerofonction();

                //  JOptionPane.showMessageDialog(null, numerofonction, "Information", JOptionPane.ERROR_MESSAGE);

            }

        } catch (Exception e) {
            //  JOptionPane.showMessageDialog(null,e.getMessage()+numfournisseur , "Information", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cbxFonctionRechEmployeItemStateChanged

    private void cbxAffectationRechEmployeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAffectationRechEmployeItemStateChanged
        // TODO add your handling code here:
        String rech = cbxAffectationRechEmploye.getSelectedItem().toString();
        Boolean trouve = false;
        String nombreemp = "";

        try {
            trouve = SysGestBricoLocalClient.dep.RechercherDepartement(rech);

            trouve = true;
            if (trouve == true) {
                numerodepartement = SysGestBricoLocalClient.dep.prendreNumerodepartement();
                //JOptionPane.showMessageDialog(null, trouve + " Start " + numerodepartement, "Selection departement", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            //  JOptionPane.showMessageDialog(null,e.getMessage()+numfournisseur , "Information", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cbxAffectationRechEmployeItemStateChanged

    private void txtRechercherEmployerIndiceCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtRechercherEmployerIndiceCaretUpdate
        // TODO add your handling code here:
        lblTotalEmploye.setText("");
        SysGestBricoLocalClient.RechercherEmploye(enteteEmploye, grilleRechEmploye, txtRechercherEmployerIndice.getText());
//        rechecherEmploye(txtRechercherEmployerIndice.getText().toString());
//        JOptionPane.showMessageDialog(null," ligne "+txtRechercherEmployerIndice.getText() , "Information", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_txtRechercherEmployerIndiceCaretUpdate

    private void txtRechercherEmployerIndiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRechercherEmployerIndiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRechercherEmployerIndiceActionPerformed

    private void txtRechercherEmployerIndicePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtRechercherEmployerIndicePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRechercherEmployerIndicePropertyChange

    private void btnAfficherEmployeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfficherEmployeActionPerformed
        // TODO add your handling code here:
        lblTotalEmploye.setText("");
        SysGestBricoLocalClient.ListerEmploye(enteteEmploye, grilleRechEmploye);
        lblTotalEmploye.setText(String.valueOf(grilleRechEmploye.getRowCount()).toString() + " employes enregistres");
        //JOptionPane.showMessageDialog(null, "ALLO ROSE!"+grilleRechEmploye.getRowCount());
//      grilleRechEmploye.setAutoscrolls(true);
//      grilleRechEmploye.setAutoResizeMode(400);
    }//GEN-LAST:event_btnAfficherEmployeActionPerformed

    private void btnAfficherEmployeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAfficherEmployeMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAfficherEmployeMouseMoved

    private void btnRechercherEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercherEmpActionPerformed
        // TODO add your handling code here:
        boolean trouveemp = false;
        boolean trouvetel = false;
        boolean trouvemail = false;
        boolean trouvesal = false;
        boolean trouvedep = false;
        String jour = "02";
        String mois = "35";
        String annee = "6";
        if ("".equals(cbxRechercherEmploye.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(null, " Saisir le numero Employe ", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                trouveemp = SysGestBricoLocalClient.emp.RechercherEmployeModifier(cbxRechercherEmploye.getSelectedItem().toString());
                numeroEmploye = SysGestBricoLocalClient.emp.prendreNumeroemploye().toString();
                trouvetel = SysGestBricoLocalClient.tel.RechercherTelephoneEmploye(numeroEmploye);
                trouvemail = SysGestBricoLocalClient.ema.RechercherEmailEmploye(numeroEmploye);
                trouvesal = SysGestBricoLocalClient.sal.RechercherSalaireEmployeModifier(numeroEmploye);
                trouvedep = SysGestBricoLocalClient.dep.RechercherDepartement(SysGestBricoLocalClient.emp.prendreNumerodepartement());
                trouveemp = true;
                if (trouveemp) {
                    if (numeroEmploye.equals(cbxRechercherEmploye.getSelectedItem().toString())) {
                        txtMatriculeRechEmploye.setText(SysGestBricoLocalClient.emp.prendreNif().toString());
                        txNomRechEmploye.setText(SysGestBricoLocalClient.emp.prendreNom().toString());
                        txPrenomRechEmploye.setText(SysGestBricoLocalClient.emp.prendrePrenom().toString());
                        cbSexeRechEmploye.setSelectedItem(SysGestBricoLocalClient.emp.prendreSexe().toString());
                        txAdresseRechEmploye.setText(SysGestBricoLocalClient.emp.prendreAdresse().toString());
                        //lblDateNais.setText(lblDateNais.getText() + ":" + SysGestBricoLocalClient.emp.prendreDatenaissance().toString());
                        String ch = SysGestBricoLocalClient.emp.prendreDatenaissance().toString();
                        jour = ch.substring(0, 2);
                        mois = ch.substring(3, 5);
                        annee = ch.substring(6);
                        cbxJourNaisRechEmploye.setSelectedItem(jour);
                        cbxMoisNaisRechEmploye.setSelectedItem(mois);
                        cbxAnneeNaisRechEmploye.setSelectedItem(annee);
                        ch = SysGestBricoLocalClient.emp.prendreDateembauche().toString();
                        jour = ch.substring(0, 2);
                        mois = ch.substring(3, 5);
                        annee = ch.substring(6);
                        cbxJourEmbaucheRechEmploye.setSelectedItem(jour);
                        cbxMoisEmbaucheRechEmploye.setSelectedItem(mois);
                        cbxAnneeEmbaucheRechEmploye.setSelectedItem(annee);
                        cbxJourEmbaucheRechEmploye.setSelectedItem(SysGestBricoLocalClient.emp.prendreDateembauche().substring(8));
                        cbxAffectationRechEmploye.setSelectedItem(SysGestBricoLocalClient.dep.prendreDepartement().toString());
                        cbxFonctionRechEmploye.setSelectedItem(SysGestBricoLocalClient.emp.prendreFonction().toString());
                        cbxSalaireRechEmploye.setSelectedItem(SysGestBricoLocalClient.sal.prendreSalaire().toString());

                        txtTelephoneRechEmploye.setText(SysGestBricoLocalClient.tel.prendreTelephone().toString());
                        txtTelephoneRechEmploye1.setText(SysGestBricoLocalClient.tel.prendreTelephone1().toString());


                        txtEmailRechEmploye.setText(SysGestBricoLocalClient.ema.prendreEmail().toString());
                        txtEmailRechEmploye1.setText(SysGestBricoLocalClient.ema.prendreEmail1().toString());

                    } else {
                        JOptionPane.showMessageDialog(null, "Numero Employe saisi non valide ", "Resultat recherche Employe", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Numero non valide", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnRechercherEmpActionPerformed

    private void cbxNumeroEmployeChargerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxNumeroEmployeChargerItemStateChanged
        // TODO add your handling code here:
        SysGestBricoLocalClient.RechercherEmployeUtil(enteteEmployeUtil, jtRechEmployeUtil, cbxNumeroEmployeCharger.getSelectedItem().toString());
    }//GEN-LAST:event_cbxNumeroEmployeChargerItemStateChanged

    private void txtMotdemasseConnCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMotdemasseConnCaretUpdate
        // TODO add your handling code here:
//        try {
//            JOptionPane.showMessageDialog(null, "Key" + txtMotdemasseConn.getText(), "Information", JOptionPane.INFORMATION_MESSAGE);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "exc" + e.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
//        }
    }//GEN-LAST:event_txtMotdemasseConnCaretUpdate

    private void txtIndiceRechercheEmployeUtilCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtIndiceRechercheEmployeUtilCaretUpdate
        // TODO add your handling code here:
        SysGestBricoLocalClient.RechercherEmployeUtil(enteteEmployeUtil, jtRechEmployeUtil, txtIndiceRechercheEmployeUtil.getText().toString());
    }//GEN-LAST:event_txtIndiceRechercheEmployeUtilCaretUpdate

    private void btnRechercherEmployerUtilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercherEmployerUtilActionPerformed
        // TODO add your handling code here:
        if (txtIndiceRechercheEmployeUtil.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Saisir un indice");
        } else {
            SysGestBricoLocalClient.RechercherEmployeUtil(enteteEmployeUtil, jtRechEmployeUtil, txtIndiceRechercheEmployeUtil.getText().toString());
        }

    }//GEN-LAST:event_btnRechercherEmployerUtilActionPerformed

    private void btnAjouterUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterUtilisateurActionPerformed
        // TODO add your handling code here:
        try {
            numeroEmploye = jtRechEmployeUtil.getValueAt(0, 0).toString();
            String ut = "";
            JOptionPane.showMessageDialog(null, numeroEmploye + txtMotPasseUtililisateur.getText());
            if (numeroEmploye.isEmpty() || txtNomUtilisateur.getText().isEmpty() || txtMotPasseUtililisateur.getText().toString().isEmpty() || cbEtatUtilisateur.getSelectedItem().toString().isEmpty() || cbRoleUtilisateur.getSelectedItem().toString().isEmpty()) {
                lblMessageUtilisateur.setForeground(Color.red);
                lblMessageUtilisateur.setText("Saisir les valeurs manquantes!");
            } else {
                try {

                    ut = SysGestBricoLocalClient.uti.AjouterUtilisateur(numeroEmploye, txtNomUtilisateur.getText(), txtMotPasseUtililisateur.getText().toString(), cbEtatUtilisateur.getSelectedItem().toString(), cbRoleUtilisateur.getSelectedItem().toString());

                    UtilisateurComboTableau();
                    JOptionPane.showMessageDialog(null, ut, "Information", JOptionPane.INFORMATION_MESSAGE);
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Utilisateur", "Ajout", txtNomUtilisateur.getText());

                    NettoyerUtilisateur();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "PROB" + e);
                }
            }
        } catch (NullPointerException f) {
            lblMessageUtilisateur.setForeground(Color.red);
            lblMessageUtilisateur.setText("L'utilisateur doit etre d'abord un employe! Rechecher le!");

        } catch (Exception t) {
            lblMessageUtilisateur.setForeground(Color.red);
            lblMessageUtilisateur.setText("Rechercher le futur utilisateur!");
        }
    }//GEN-LAST:event_btnAjouterUtilisateurActionPerformed

    private void txtMotPasseUtililisateurCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMotPasseUtililisateurCaretUpdate
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, txtMotPasseUtililisateur.getText().length());
        //lblMessageUtilisateur.setText("mot de passe faible! saisir entre 5 a 29 caracteres");
        int i = txtMotPasseUtililisateur.getText().length();
        if (i <= 5) {
            lblMessageUtilisateur.setForeground(Color.red);
            lblMessageUtilisateur.setText("mot de passe faible! saisir entre 5 a 19 caracteres");
        } else if (i <= 9) {
            lblMessageUtilisateur.setForeground(Color.orange);
            lblMessageUtilisateur.setText("mot de passe moyen! securite peu eleve");
        } else if (i > 9 && i < 20) {
            lblMessageUtilisateur.setForeground(Color.green);
            lblMessageUtilisateur.setText("mot de passe fort! securite eleve");
        } else if (i >= 20) {
            lblMessageUtilisateur.setForeground(Color.red);
            lblMessageUtilisateur.setText("mot de passe trop longue");
        } else {
            lblMessageUtilisateur.setForeground(Color.black);
            lblMessageUtilisateur.setText("");
        }
    }//GEN-LAST:event_txtMotPasseUtililisateurCaretUpdate

    private void txtRepeterMotpasseUtilisateurCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtRepeterMotpasseUtilisateurCaretUpdate
        // TODO add your handling code here:
        int i = txtMotPasseUtililisateur.getText().length();
        if (txtRepeterMotpasseUtilisateur.getText().equals(txtMotPasseUtililisateur.getText())) {
            lblMessageUtilisateur.setForeground(Color.black);
            lblMessageUtilisateur.setText("");
            btnAjouterUtilisateur.setEnabled(true);
        } else {

            lblMessageUtilisateur.setForeground(Color.red);
            lblMessageUtilisateur.setText("mot de passe repete non compatible !Repeter mot de passe");
            btnAjouterUtilisateur.setEnabled(false);
        }
    }//GEN-LAST:event_txtRepeterMotpasseUtilisateurCaretUpdate

    private void txtNomUtilisateurCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomUtilisateurCaretUpdate
        // TODO add your handling code here:
        int i = txtNomUtilisateur.getText().length();
        if (i <= 3) {
            lblMessageUtilisateur.setForeground(Color.red);
            lblMessageUtilisateur.setText("nom utilisateur trop court! saisir entre 4 a 29 caracteres");

        } else if (i >= 29) {
            lblMessageUtilisateur.setForeground(Color.red);
            lblMessageUtilisateur.setText("Nom utilisateur trop long");
        } else {
            lblMessageUtilisateur.setForeground(Color.black);
            lblMessageUtilisateur.setText("");
        }
    }//GEN-LAST:event_txtNomUtilisateurCaretUpdate

    private void cbxRechercherUtilisateurNomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxRechercherUtilisateurNomItemStateChanged
        // TODO add your handling code here:
        String role = "";

        try {
            SysGestBricoLocalClient.uti.RechercherUtilisateur(cbxRechercherUtilisateurNom.getSelectedItem().toString());
            //SysGestBricoLocalClient.uti.RechercherMotDePasseUtilisateur(cbxRechercherUtilisateurNom.getSelectedItem().toString());
            numeroEmploye = SysGestBricoLocalClient.uti.prendreNumeroemploye();
            txtNomUtilisateurRech.setText(SysGestBricoLocalClient.uti.prendreNomutilisateur());
            txtMotPasseUtilRech.setText(SysGestBricoLocalClient.uti.prendreMotdepasse());
            txtRepeterMotpasseUtilRech.setText(SysGestBricoLocalClient.uti.prendreMotdepasse());

            cbRoleUtilisateurRechecher.setSelectedItem(SysGestBricoLocalClient.uti.prendreRoleUtilisateur());
            cbEtatUtilisateurRechercher.setSelectedItem(SysGestBricoLocalClient.uti.prendreEtatutilisateur());
            // lbMessageUtilisateurRech.setText("tr"+SysGestBricoLocalClient.uti.prendreMotdepasse());
        } catch (Exception e) {
            lbMessageUtilisateurRech.setText("prob" + e + txtRepeterMotpasseUtilRech.getText());

        }

    }//GEN-LAST:event_cbxRechercherUtilisateurNomItemStateChanged

    private void btnModifierUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierUtilisateurActionPerformed
        // TODO add your handling code here:
        String ut = "";
        try {
            //JOptionPane.showMessageDialog(null, numeroEmploye + txtMotPasseUtililisateur.getText());
            if (numeroEmploye.isEmpty() || txtNomUtilisateurRech.getText().isEmpty() || txtMotPasseUtilRech.getText().toString().isEmpty() || cbRoleUtilisateurRechecher.getSelectedItem().toString().isEmpty() || cbEtatUtilisateurRechercher.getSelectedItem().toString().isEmpty()) {
                lbMessageUtilisateurRech.setForeground(Color.red);
                lbMessageUtilisateurRech.setText("Saisir les valeurs manquantes!");
            } else {
                try {
                    int rep = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (rep == JOptionPane.YES_OPTION) {
                        ut = SysGestBricoLocalClient.uti.ModifierUtilisateur(numeroEmploye, txtNomUtilisateurRech.getText(), txtMotPasseUtilRech.getText(), cbRoleUtilisateurRechecher.getSelectedItem().toString(), cbEtatUtilisateurRechercher.getSelectedItem().toString());
                        //ut=   SysGestBricoLocalClient.uti.AjouterUtilisateur(numeroEmploye,txtNomUtilisateur.getText(),txtMotPasseUtililisateur.getText().toString(),cbEtatUtilisateur.getSelectedItem().toString() ,cbRoleUtilisateur.getSelectedItem().toString());
                        lbMessageUtilisateurRech.setText(ut);
                        SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Utilisateur", "Modification", txtNomUtilisateurRech.getText());
                        JOptionPane.showMessageDialog(null, ut);
                        UtilisateurComboTableau();
                        NettoyerUtilisateur();
                    } else {
                        NettoyerUtilisateur();
                    }
                } catch (Exception e) {
                    lbMessageUtilisateurRech.setText("PROB" + e);
                }
            }
        } catch (NullPointerException f) {
            lbMessageUtilisateurRech.setForeground(Color.red);
            lbMessageUtilisateurRech.setText("L'utilisateur doit etre d'abord charger! Rechecher le!");

        } catch (Exception t) {
            lbMessageUtilisateurRech.setForeground(Color.red);
            lbMessageUtilisateurRech.setText("Rechercher le futur utilisateur!");
        }
    }//GEN-LAST:event_btnModifierUtilisateurActionPerformed

    private void txtMotPasseUtilRechCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMotPasseUtilRechCaretUpdate
        // TODO add your handling code here:
        int i = txtMotPasseUtilRech.getText().length();
        if (i <= 5) {
            lbMessageUtilisateurRech.setForeground(Color.red);
            lbMessageUtilisateurRech.setText("mot de passe faible! saisir entre 5 a 19 caracteres");
        } else if (i <= 9) {
            lbMessageUtilisateurRech.setForeground(Color.orange);
            lbMessageUtilisateurRech.setText("mot de passe moyen! securite peu eleve");
        } else if (i > 9 && i < 20) {
            lbMessageUtilisateurRech.setForeground(Color.green);
            lbMessageUtilisateurRech.setText("mot de passe fort! securite eleve");
        } else if (i >= 20) {
            lbMessageUtilisateurRech.setForeground(Color.red);
            lbMessageUtilisateurRech.setText("mot de passe trop longue");
        } else {
            lbMessageUtilisateurRech.setForeground(Color.black);
            lbMessageUtilisateurRech.setText("");
        }
    }//GEN-LAST:event_txtMotPasseUtilRechCaretUpdate

    private void txtRepeterMotpasseUtilRechCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtRepeterMotpasseUtilRechCaretUpdate
        // TODO add your handling code here:
        int i = txtMotPasseUtililisateur.getText().length();
        if (txtRepeterMotpasseUtilRech.getText().equals(txtMotPasseUtilRech.getText())) {
            lbMessageUtilisateurRech.setForeground(Color.black);
            lbMessageUtilisateurRech.setText("");
            lbMessageUtilisateurRech.setEnabled(true);
        } else {

            lbMessageUtilisateurRech.setForeground(Color.red);
            lbMessageUtilisateurRech.setText("mot de passe repete non compatible !Repeter mot de passe");
            lbMessageUtilisateurRech.setEnabled(false);
        }
    }//GEN-LAST:event_txtRepeterMotpasseUtilRechCaretUpdate

    private void cbxNomUtilisateurRechercherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxNomUtilisateurRechercherItemStateChanged
        // TODO add your handling code here:
        SysGestBricoLocalClient.ListerUtilisateurParindice(cbxNomUtilisateurRechercher.getSelectedItem().toString(), enteteUtilisateur, grilleUtilisateur1);
        SysGestBricoLocalClient.ListerUtilisateurParindice1(cbxNomUtilisateurRechercher.getSelectedItem().toString(), enteteUtilisateur1, grilleUtilisateur2);

    }//GEN-LAST:event_cbxNomUtilisateurRechercherItemStateChanged

    private void btnListerUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListerUtilisateurActionPerformed
        // TODO add your handling code here:
        try {
             SysGestBricoLocalClient.ListerUtilisateur(enteteUtilisateur, grilleUtilisateur1);
        SysGestBricoLocalClient.ListerUtilisateur1(enteteUtilisateur1, grilleUtilisateur2);
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(cbxvt, e.getMessage());
        }
       
    }//GEN-LAST:event_btnListerUtilisateurActionPerformed

    private void cbxEtatUtilisateurRechercherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEtatUtilisateurRechercherItemStateChanged
        // TODO add your handling code here:
        SysGestBricoLocalClient.ListerUtilisateurParindice(cbxEtatUtilisateurRechercher.getSelectedItem().toString(), enteteUtilisateur, grilleUtilisateur1);
        SysGestBricoLocalClient.ListerUtilisateurParindice1(cbxEtatUtilisateurRechercher.getSelectedItem().toString(), enteteUtilisateur1, grilleUtilisateur2);

    }//GEN-LAST:event_cbxEtatUtilisateurRechercherItemStateChanged

    private void cbxEtatConnexionUtilisateurRechercherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEtatConnexionUtilisateurRechercherItemStateChanged
        // TODO add your handling code here:
        SysGestBricoLocalClient.ListerUtilisateurParindice(cbxEtatConnexionUtilisateurRechercher.getSelectedItem().toString(), enteteUtilisateur, grilleUtilisateur1);
        SysGestBricoLocalClient.ListerUtilisateurParindice1(cbxEtatConnexionUtilisateurRechercher.getSelectedItem().toString(), enteteUtilisateur1, grilleUtilisateur2);

    }//GEN-LAST:event_cbxEtatConnexionUtilisateurRechercherItemStateChanged

    private void cbxroleUtilisateurRechercherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxroleUtilisateurRechercherItemStateChanged
        // TODO add your handling code here:
        SysGestBricoLocalClient.ListerUtilisateurParindice(cbxroleUtilisateurRechercher.getSelectedItem().toString(), enteteUtilisateur, grilleUtilisateur1);
        SysGestBricoLocalClient.ListerUtilisateurParindice1(cbxroleUtilisateurRechercher.getSelectedItem().toString(), enteteUtilisateur1, grilleUtilisateur2);

    }//GEN-LAST:event_cbxroleUtilisateurRechercherItemStateChanged

    private void cbxLibelleArticleVenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLibelleArticleVenteItemStateChanged
        // TODO add your handling code here:
        boolean tr = false;
        try {
            tr = SysGestBricoLocalClient.sto.RechercherStock(cbxLibelleArticleVente.getSelectedItem().toString());
            tr = true;
            float p = SysGestBricoLocalClient.sto.prendrePrix();
            numeroarticle = SysGestBricoLocalClient.sto.prendreNumeroarticle();
            QuantiteArticle = SysGestBricoLocalClient.sto.prendreQuantite();
            if (tr) {
                txtPrixArticleVente.setText(String.valueOf(p));
            } else {
                lblMessageVente.setText("Prix non valide");
            }
        } catch (Exception e) {
            lblMessageVente.setText("Prod" + e.getMessage());
        }
    }//GEN-LAST:event_cbxLibelleArticleVenteItemStateChanged

    private void txtQuantiteArticleVenteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtQuantiteArticleVenteCaretUpdate
        // TODO add your handling code here:
        try {
            if (txtQuantiteArticleVente.getText().toString() != "" && (txtQuantiteArticleVente.getText().charAt(0) != '0')) {
                try {
                    int qt = Integer.valueOf(txtQuantiteArticleVente.getText().toString());
                    if (QuantiteArticle < qt) {
                        btnAjouterLigneVente.setEnabled(false);
                        lblMessageVente.setForeground(Color.red);
                        lblMessageVente.setText("Quantite non disponible! Disponible " + QuantiteArticle);
                    } else if (1 <= qt) {
                        lblMessageVente.setForeground(Color.blue);
                        lblMessageVente.setText("");
                        btnAjouterLigneVente.setEnabled(true);
                    }
                } catch (NumberFormatException e) {
                    lblMessageVente.setForeground(Color.red);
                    lblMessageVente.setText("Quantite non valide:" + txtQuantiteArticleVente.getText().toString());
                    btnAjouterLigneVente.setEnabled(false);
                }
            }
        } catch (Exception e) {
            lblMessageVente.setForeground(Color.orange);
            lblMessageVente.setText("la Quantite ne doit pas debuter par zero '0' " + txtQuantiteArticleVente.getText().toString());
            btnAjouterLigneVente.setEnabled(false);
        }
    }//GEN-LAST:event_txtQuantiteArticleVenteCaretUpdate

    private void btnAjouterLigneVenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterLigneVenteActionPerformed
        // TODO add your handling code here:
        String k = "";
        try {
            soustotalvente = Integer.valueOf(txtQuantiteArticleVente.getText().toString()) * (Float.valueOf(txtPrixArticleVente.getText().toString()));
            prixtotalvente += soustotalvente;
            QuantiteArticletotalvente += 1;
            k = numeroarticle + ";" + cbxLibelleArticleVente.getSelectedItem().toString() + ";" + txtPrixArticleVente.getText().toString() + ";" + txtQuantiteArticleVente.getText().toString() + ";" + soustotalvente + ";" + Nomutilisateur + ";";

            cbxvt.insertItemAt(k, 0);
            k = "";
            AjouterLigneVente(tet, grilleVente);

            //JOptionPane.showMessageDialog(this, k + " Enregistrement reussi!\n " + cbxvt.getSelectedItem());
            lblNombreArticleVente.setText(QuantiteArticletotalvente + " articles");
            lblPrixtotalvente.setText(prixtotalvente + " $");
            //cbxvt.setSelectedItem(cbxvt.getItemAt(1));
            txtPrixArticleVente.setText("0.0");
            txtQuantiteArticleVente.setText("");
            btnAjouterLigneVente.setEnabled(false);
            btnVenteVente.setEnabled(true);



        } catch (Exception e) {
            lblMessageVente.setForeground(Color.red);
            lblMessageVente.setText("Prob ligne article:" + e.getMessage());
        }

    }//GEN-LAST:event_btnAjouterLigneVenteActionPerformed

    private void cbxvtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxvtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxvtActionPerformed

    private void btnValiderVenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValiderVenteActionPerformed
        // TODO add your handling code here:
        String v = "";
        if (txtNomClient.getText().isEmpty() || txtTelephoneClient.getText().isEmpty() || txtAdresseClient.getText().isEmpty() || txtEmailClient.getText().isEmpty()) {
            numeroclient = "Client non-identifie";
            lblMessageVente.setText("Saisir les informations ou manquantes du client!");


        } else if (trouveClient == true) {
            try {
                numerovente = SysGestBricoLocalClient.ven.codeVente();
                numeroclient = SysGestBricoLocalClient.cli.prendreNumeroClients();
                trouveClient = false;
                int i = 0;
                while (i < grilleVente.getRowCount()) {
                    v = SysGestBricoLocalClient.ven.AjouterVente(numerovente, grilleVente.getValueAt(i, 0).toString(), numeroclient, Integer.valueOf(grilleVente.getValueAt(i, 3).toString()), Float.valueOf(grilleVente.getValueAt(i, 4).toString()), numerovente, grilleVente.getValueAt(i, 5).toString());
                    SysGestBricoLocalClient.sto.ModifierStock(numeroarticle, Integer.valueOf(grilleVente.getValueAt(i, 3).toString()));
                    lblMessageVente.setText(v + "! code client:" + numeroclient + "! Monnaie a rembourser: " + (qt - prixtotalvente) + " $");
                    i++;
                }
                i = 0;
                lblMessageVente.setText(v + "! code client:" + numeroclient + "! Monnaie a rembourser: " + (qt - prixtotalvente) + " $");
                SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Vente", "Effectuer vente", numerovente);
                NettoyerVente();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "exception:" + ex.getMessage(), "Message d'erreur", JOptionPane.ERROR_MESSAGE);
            }

        } else {

            try {

                numeroclient = "";
                numeroclient = SysGestBricoLocalClient.cli.AjouterClient("", txtNomClient.getText().trim(), txtAdresseClient.getText().trim(), txtTelephoneClient.getText().trim(), txtEmailClient.getText().trim());
                numerovente = SysGestBricoLocalClient.ven.codeVente();
                if (numeroclient != "") {
                    //lblMessageVente.setText("Client prob "+numeroclient);
                    int i = 0;
                    while (i < grilleVente.getRowCount()) {
                        v = SysGestBricoLocalClient.ven.AjouterVente(numerovente, grilleVente.getValueAt(i, 0).toString(), numeroclient, Integer.valueOf(grilleVente.getValueAt(i, 3).toString()), Float.valueOf(grilleVente.getValueAt(i, 4).toString()), numerovente, grilleVente.getValueAt(i, 5).toString());
                        SysGestBricoLocalClient.sto.ModifierStock(numeroarticle, Integer.valueOf(grilleVente.getValueAt(i, 3).toString()));
                        lblMessageVente.setText(v + "! code client:" + numeroclient + "! Monnaie a rembourser: " + (qt - prixtotalvente) + " $");
                        i++;
                    }
                    i = 0;
                    lblMessageVente.setText(v + "! code client:" + numeroclient + "! Monnaie a rembourser: " + (qt - prixtotalvente) + " $");
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Vente", "Effectuer vente", numerovente);
                    NettoyerVente();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "exception:" + ex.getMessage(), "Message d'erreur", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnValiderVenteActionPerformed

    private void txtAdresseClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdresseClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdresseClientActionPerformed

    private void txMontantRecuCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txMontantRecuCaretUpdate
        // TODO add your handling code here:
        try {
            if (txMontantRecu.getText().toString() != "" && (txMontantRecu.getText().charAt(0) != '0')) {
                try {
                    qt = Float.valueOf(txMontantRecu.getText().toString());
                    if (prixtotalvente > qt) {
                        btnValiderVente.setEnabled(false);
                        lblMessageVente.setForeground(Color.red);
                        lblMessageVente.setText("L'argent non suffisant! Montant vente: " + prixtotalvente);
                    } else if (prixtotalvente <= qt) {
                        lblMessageVente.setForeground(Color.blue);
                        lblMessageVente.setText("Monnaie a rembourser: " + (qt - prixtotalvente) + " $");
                        btnValiderVente.setEnabled(true);
                    }
                } catch (NumberFormatException e) {
                    lblMessageVente.setForeground(Color.red);
                    lblMessageVente.setText("Quantite non valide:" + txMontantRecu.getText().toString());
                    btnValiderVente.setEnabled(false);
                }
            }
        } catch (Exception e) {
            lblMessageVente.setForeground(Color.orange);
            lblMessageVente.setText("le montant ne doit pas debuter par zero '0' " + txMontantRecu.getText().toString());
            btnValiderVente.setEnabled(false);
        }
    }//GEN-LAST:event_txMontantRecuCaretUpdate

    private void txtNomClientCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomClientCaretUpdate
        // TODO add your handling code here:
        try {
            trouveClient = SysGestBricoLocalClient.cli.RechercherClient(txtNomClient.getText().toString());
            trouveClient = true;
            if (trouveClient) {
                txtTelephoneClient.setText(SysGestBricoLocalClient.cli.prendreTelephone().toString());
                txtEmailClient.setText(SysGestBricoLocalClient.cli.prendreEmail().toString());
                txtAdresseClient.setText(SysGestBricoLocalClient.cli.prendreAdresse().toString());
                txtNomClient.setText(SysGestBricoLocalClient.cli.prendreNom().toString());
                numeroclient = SysGestBricoLocalClient.cli.prendreNumeroClients().toString();
            } else {
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtNomClientCaretUpdate

    private void btnRetirerArticleVenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirerArticleVenteActionPerformed
        // TODO add your handling code here:
        try {
            int j = JOptionPane.showConfirmDialog(null, "Cliquer sur 'Yes' pour retourner l'article!", "Confirmer", 2);
            if (j == 0) {

                cbxvt.removeItemAt(Integer.valueOf(cbxRetirerArticleVente.getSelectedItem().toString()));
                AjouterLigneVente(tet, grilleVente);
                int i = 0;
                soustotalvente = 0;
                QuantiteArticletotalvente = 0;
                prixtotalvente = 0;

                while (i < grilleVente.getRowCount()) {
//              v=SysGestBricoLocalClient.ven.AjouterVente(numerovente, grilleVente.getValueAt(i, 0).toString(),numeroclient,Integer.valueOf(grilleVente.getValueAt(i, 3).toString()),Float.valueOf( grilleVente.getValueAt(i, 4).toString()), numerovente, grilleVente.getValueAt(i, 5).toString());
//              SysGestBricoLocalClient.sto.ModifierStock(numeroarticle, Integer.valueOf(grilleVente.getValueAt(i, 3).toString()));
                    soustotalvente += (Float.valueOf(grilleVente.getValueAt(i, 4).toString()));

                    QuantiteArticletotalvente = i + 1;
                    lblNombreArticleVente.setText(QuantiteArticletotalvente + " articles");
                    lblPrixtotalvente.setText(soustotalvente + " $");
                    i++;
                }
                lblMessageVente.setText("tot " + soustotalvente + "qt " + QuantiteArticletotalvente);
                prixtotalvente = soustotalvente;
                //retirerArticle=true;
                i = 0;
            }
        } catch (Exception e) {
            lblMessageVente.setText("Prob " + e.getMessage());
        }
    }//GEN-LAST:event_btnRetirerArticleVenteActionPerformed

    private void cbxRechercherUtilisateurDBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxRechercherUtilisateurDBItemStateChanged
        // TODO add your handling code here:
        BtBloquerUtilisateur.setEnabled(false);
        BtDebloquerUtilisateur.setEnabled(false);
        try {
            // TODO add your handling code here:
            boolean trouve = false;
            String rech = cbxRechercherUtilisateurDB.getSelectedItem().toString();
            trouve = SysGestBricoLocalClient.uti.RechercherUtilisateur(rech);
            if (trouve) {
                txtNomUtilisateurRechEtat.setText(SysGestBricoLocalClient.uti.prendreNomutilisateur());
                txtRoleUtilisateurRechEtat.setText(SysGestBricoLocalClient.uti.prendreRoleUtilisateur());
                txtEtatUtilisateurRechEtat.setText(SysGestBricoLocalClient.uti.prendreEtatutilisateur());
                if (txtEtatUtilisateurRechEtat.getText().equals("Bloque")) {
                    BtDebloquerUtilisateur.setEnabled(true);
                } else if (txtEtatUtilisateurRechEtat.getText().equals("Debloque")) {
                    BtBloquerUtilisateur.setEnabled(true);
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbxRechercherUtilisateurDBItemStateChanged

    private void BtBloquerUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBloquerUtilisateurActionPerformed
        // TODO add your handling code here:
        String message = "";
        try {
            int rep = JOptionPane.showConfirmDialog(null, "Voulez vous bloquer " + txtNomUtilisateurRechEtat.getText(), "Confirmation", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                message = SysGestBricoLocalClient.uti.ModifierEtatUtilisateur(txtNomUtilisateurRechEtat.getText(), "Bloque");

                if (message != "") {
                    JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Utilisateur", "Modification", txtNomUtilisateurRechEtat.getText());

                    BtBloquerUtilisateur.setEnabled(false);
                    txtNomUtilisateurRechEtat.setText("");
                    txtRoleUtilisateurRechEtat.setText("");
                    txtEtatUtilisateurRechEtat.setText("");

                }
            } else {
                BtBloquerUtilisateur.setEnabled(false);
                txtNomUtilisateurRechEtat.setText("");
                txtRoleUtilisateurRechEtat.setText("");
                txtEtatUtilisateurRechEtat.setText("");
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null,ex.getMessage(),"Information", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtBloquerUtilisateurActionPerformed

    private void BtDebloquerUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtDebloquerUtilisateurActionPerformed
        // TODO add your handling code here:
        String message = "";
        try {
            int rep = JOptionPane.showConfirmDialog(null, "Voulez vous debloquer " + txtNomUtilisateurRechEtat.getText(), "Confirmation", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                message = SysGestBricoLocalClient.uti.ModifierEtatUtilisateur(txtNomUtilisateurRechEtat.getText(), "Debloque");

                if (message != "") {
                    JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                    SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Utilisateur", "Modification", txtNomUtilisateurRechEtat.getText());

                    BtDebloquerUtilisateur.setEnabled(false);
                    txtNomUtilisateurRechEtat.setText("");
                    txtRoleUtilisateurRechEtat.setText("");
                    txtEtatUtilisateurRechEtat.setText("");
                }
            } else {
                BtDebloquerUtilisateur.setEnabled(false);
                txtNomUtilisateurRechEtat.setText("");
                txtRoleUtilisateurRechEtat.setText("");
                txtEtatUtilisateurRechEtat.setText("");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtDebloquerUtilisateurActionPerformed

    private void btnRechercherMotdepasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercherMotdepasseActionPerformed
        // TODO add your handling code here:
        boolean trouve = false;
        if (txtNomUtilisateurRechercherMotdepasse.getText().equals("") || txtModPasseRechercherMotdepasse.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Saisissez votre nom utilisateur et ou mot de passe!", "Erreur de saisir", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                trouve = SysGestBricoLocalClient.uti.RechercherMotDePasseUtilisateur(txtNomUtilisateurRechercherMotdepasse.getText(), txtModPasseRechercherMotdepasse.getText());
                if (trouve && SysGestBricoLocalClient.uti.prendreMotdepasse().equals(txtModPasseRechercherMotdepasse.getText().toString())) {
                    // btnModifierMotPasse.setEnabled(true);
                    txtAncienMotDePasse.setText(SysGestBricoLocalClient.uti.prendreMotdepasse());
                    Nomutilisateur = txtNomUtilisateurRechercherMotdepasse.getText();

                } else {
                    JOptionPane.showMessageDialog(null, "Enregistrement non trouve", "Avertissement", JOptionPane.ERROR_MESSAGE);
                }

            } catch (RemoteException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnRechercherMotdepasseActionPerformed

    private void btnModifierMotPasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierMotPasseActionPerformed
        // TODO add your handling code here:
        String message = "";
        if (TxtNouveauMotPasse.getText().equals("") || txtNouveauMotPasserepeter.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Entrer le mot de passe a modifier", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                int rep = JOptionPane.showConfirmDialog(null, "Voulez vous modifier le mot de passe ", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (rep == JOptionPane.YES_OPTION) {
                    message = SysGestBricoLocalClient.uti.ModifierMotDEPasseUtilisateur(txtNomUtilisateurRechercherMotdepasse.getText(), TxtNouveauMotPasse.getText());

                    if (message != "") {
                        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                        SysGestBricoLocalClient.traceeutilisateur(Nomutilisateur, "Utilisateur", "Modification", txtNomUtilisateurRechercherMotdepasse.getText());

                        //  lblMessageUtilisateur1.setText(message);
                        txtAncienMotDePasse.setText("");
                        TxtNouveauMotPasse.setText("");
                        txtNouveauMotPasserepeter.setText("");
                        txtNomUtilisateurRechercherMotdepasse.setText("");
                        txtModPasseRechercherMotdepasse.setText("");
                    }
                } else {
                    txtAncienMotDePasse.setText("");
                    TxtNouveauMotPasse.setText("");
                    txtNouveauMotPasserepeter.setText("");
                    txtNomUtilisateurRechercherMotdepasse.setText("");
                    txtModPasseRechercherMotdepasse.setText("");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModifierMotPasseActionPerformed

    private void TxtNouveauMotPasseCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TxtNouveauMotPasseCaretUpdate
        // TODO add your handling code here:
        int i = TxtNouveauMotPasse.getText().length();
        if (i <= 5) {
            lblMessageUtilisateur1.setForeground(Color.red);
            lblMessageUtilisateur1.setText("mot de passe faible! saisir entre 5 a 19 caracteres");
        } else if (i <= 9) {
            lblMessageUtilisateur1.setForeground(Color.orange);
            lblMessageUtilisateur1.setText("mot de passe moyen! securite peu eleve");
        } else if (i > 9 && i < 20) {
            lblMessageUtilisateur1.setForeground(Color.green);
            lblMessageUtilisateur1.setText("mot de passe fort! securite eleve");
        } else if (i >= 20) {
            lblMessageUtilisateur1.setForeground(Color.red);
            lblMessageUtilisateur1.setText("mot de passe trop longue");
        } else {
            lblMessageUtilisateur1.setForeground(Color.black);
            lblMessageUtilisateur1.setText("");
        }
    }//GEN-LAST:event_TxtNouveauMotPasseCaretUpdate

    private void txtNouveauMotPasserepeterCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNouveauMotPasserepeterCaretUpdate
        // TODO add your handling code here:
        int i = txtNouveauMotPasserepeter.getText().length();
        if (txtNouveauMotPasserepeter.getText().equals(TxtNouveauMotPasse.getText())) {
            lblMessageUtilisateur1.setForeground(Color.black);
            lblMessageUtilisateur1.setText("");
            //btnAjouterUtilisateur.setEnabled(true);
        } else {

            lblMessageUtilisateur1.setForeground(Color.red);
            lblMessageUtilisateur1.setText("mot de passe repete non compatible !Repeter mot de passe");
            // btnAjouterUtilisateur.setEnabled(false);
        }
    }//GEN-LAST:event_txtNouveauMotPasserepeterCaretUpdate

    private void cbxRetirerArticleVenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxRetirerArticleVenteItemStateChanged
        // TODO add your handling code here:
        if (cbxRetirerArticleVente.getSelectedItem().toString() != "") {
            btnRetirerArticleVente.setEnabled(true);
        } else if (cbxRetirerArticleVente.getSelectedItem().toString().isEmpty()) {
            btnRetirerArticleVente.setEnabled(false);
        }
    }//GEN-LAST:event_cbxRetirerArticleVenteItemStateChanged

    private void txtNumeroVenteArticleCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNumeroVenteArticleCaretUpdate
        // TODO add your handling code here:

        try {
            SysGestBricoLocalClient.RechercherVenteIndice(enteteVente, Grillerechvente, txtNumeroVenteArticle.getText().toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_txtNumeroVenteArticleCaretUpdate

    private void btnVenteVenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenteVenteActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(null, "Cliquer sur 'Yes' pour confirmer l'annulation de la vente !", "Confirmer", 2);
        if (i == 0) {
            NettoyerVente();
            btnVenteVente.setEnabled(false);
        }

    }//GEN-LAST:event_btnVenteVenteActionPerformed

    private void btnMenuHautActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuHautActionPerformed
        // TODO add your handling code here:
        TbArticle.setTabPlacement(1);
        TbAjouterArticle.setTabPlacement(1);
        Categorie.setTabPlacement(1);
        //Commande.setTabPlacement(1);
        Utilisateur.setTabPlacement(1);
        Outils.setTabPlacement(1);
        Employe.setTabPlacement(1);
        Fournisseur.setTabPlacement(1);
        Payroll.setTabPlacement(1);
        Vente.setTabPlacement(1);
        Achat.setTabPlacement(1);
        gauche = false;
        haut = true;
    }//GEN-LAST:event_btnMenuHautActionPerformed

    private void btnDeconnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeconnecterActionPerformed
        // TODO add your handling code here:
        try {
            SysGestBricoLocalClient.ModifierEtatConnexion(Nomutilisateur, "Non");
            Nomutilisateur = null;
            this.dispose();

            SysGestBricoLocalClient.demarrer();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnDeconnecterActionPerformed

    private void btnChagerMotPasseUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChagerMotPasseUtActionPerformed
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Utilisateur);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnUtil" + e.getMessage());
        }
    }//GEN-LAST:event_btnChagerMotPasseUtActionPerformed

    private void btnEmployeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeActionPerformed
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Employe);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnUtil" + e.getMessage());
        }
    }//GEN-LAST:event_btnEmployeActionPerformed

    private void btnPayrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayrollActionPerformed
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Payroll);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnUtil" + e.getMessage());
        }
    }//GEN-LAST:event_btnPayrollActionPerformed

    private void btnOutilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutilActionPerformed
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Outils);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnUtil" + e.getMessage());
        }
    }//GEN-LAST:event_btnOutilActionPerformed

    private void btnArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticleActionPerformed
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Article);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnUtil" + e.getMessage());
        }
    }//GEN-LAST:event_btnArticleActionPerformed

    private void btnVenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenteActionPerformed
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Vente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnUtil" + e.getMessage());
        }
    }//GEN-LAST:event_btnVenteActionPerformed

    private void btnCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategorieActionPerformed
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Categorie);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnUtil" + e.getMessage());
        }

    }//GEN-LAST:event_btnCategorieActionPerformed

    private void btnAchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAchatActionPerformed
        // TODO add your handling code here:
        try {
            TbArticle.setSelectedComponent(Achat);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prob MnUtil" + e.getMessage());
        }
    }//GEN-LAST:event_btnAchatActionPerformed

    private void btnTraceUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraceUtilisateurActionPerformed
        // TODO add your handling code here:
        try {
            SysGestBricoLocalClient.ListerTracee(enteteHistorique, jtTracee);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnTraceUtilisateurActionPerformed

    private void txtIndiceTraceeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtIndiceTraceeCaretUpdate
        // TODO add your handling code here:
        try {
            SysGestBricoLocalClient.ListerTraceeParindice(txtIndiceTracee.getText().toString().trim(), enteteHistorique, jtTracee);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_txtIndiceTraceeCaretUpdate

    private void cbxMoisPayrollItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMoisPayrollItemStateChanged
        // TODO add your handling code here:
        if(cbxMoisPayroll.getSelectedItem().toString().equals("Choisir mois")){
           btnEffectuerPayroll.setVisible(false);
         lblMessagePayroll.setForeground(Color.red);
                lblMessagePayroll.setText("Choisir le mois que vous desirez effectuer le payroll");  
        }
        else{
        String datepayroll="";
        String trouve="";
         lblMessagePayroll.setText("");
        try {
            trouve=SysGestBricoLocalClient.pay.RechercherPayroll(cbxMoisPayroll.getSelectedItem().toString(),ser.annee);
            datepayroll=SysGestBricoLocalClient.pay.prendreDatepayroll();
            if(trouve.equals(""))
                {
                   btnEffectuerPayroll.setVisible(true);
                  SysGestBricoLocalClient.PreparerPayroll(entetePayroll, GrillePreparerPayroll, cbxMoisPayroll.getSelectedItem().toString());
            int i = 0;
            float mont = 0;
            lblNombreEmployeCharger.setForeground(Color.BLUE);

            lblNombreEmployeCharger.setText("Nombre d'employes:" + GrillePreparerPayroll.getRowCount());
            while (GrillePreparerPayroll.getRowCount() > i) {
                mont += Float.valueOf(GrillePreparerPayroll.getValueAt(i, 3).toString());
                i++;
            }
            i = 0;
            lblMontantTotalPayroll.setForeground(Color.BLUE);
            lblMontantTotalPayroll.setText("Montant payroll: " + mont + " $");
             }
            else{
//        try {
                
        btnEffectuerPayroll.setVisible(false);
         lblMessagePayroll.setForeground(Color.red);
                lblMessagePayroll.setText(trouve);
           
          
       // }  
//    catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
        }
        } catch (Exception e) {
        }
        }
    }//GEN-LAST:event_cbxMoisPayrollItemStateChanged

    private void txEmailEmployeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txEmailEmployeCaretUpdate
        // TODO add your handling code here:
        EmailPat(txEmailEmploye, btnenregistrerEmploye, lblMessageEmploye);

    }//GEN-LAST:event_txEmailEmployeCaretUpdate

    private void txEmailEmploye1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txEmailEmploye1CaretUpdate
        // TODO add your handling code here:
        EmailPat(txEmailEmploye1, btnenregistrerEmploye, lblMessageEmploye);
    }//GEN-LAST:event_txEmailEmploye1CaretUpdate

    private void txtEmailRechEmployeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEmailRechEmployeCaretUpdate
        // TODO add your handling code here:
        EmailPat(txtEmailRechEmploye, btnModifierEmploye, lblMessageEmployeModifier);
    }//GEN-LAST:event_txtEmailRechEmployeCaretUpdate

    private void txtEmailRechEmploye1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEmailRechEmploye1CaretUpdate
        // TODO add your handling code here:
        EmailPat(txtEmailRechEmploye1, btnModifierEmploye, lblMessageEmployeModifier);
    }//GEN-LAST:event_txtEmailRechEmploye1CaretUpdate

    private void txtEmailClientCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEmailClientCaretUpdate
        // TODO add your handling code here:
        EmailPat(txtEmailClient, btnValiderVente, lblMessageClient);
    }//GEN-LAST:event_txtEmailClientCaretUpdate

    private void txtEmaillFournisseurCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEmaillFournisseurCaretUpdate
        // TODO add your handling code here:
        EmailPat(txtEmaillFournisseur, btnajouterFournisseur, lblMessageFournisseur);
    }//GEN-LAST:event_txtEmaillFournisseurCaretUpdate

    private void txEmailFournisseur4CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txEmailFournisseur4CaretUpdate
        // TODO add your handling code here:
        EmailPat(txEmailFournisseur4, btnajouterFournisseur, lblMessageFournisseur);

    }//GEN-LAST:event_txEmailFournisseur4CaretUpdate

    private void txEmailFournisseur3CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txEmailFournisseur3CaretUpdate
        // TODO add your handling code here:
        EmailPat(txEmailFournisseur3, btnajouterFournisseur, lblMessageFournisseur);
    }//GEN-LAST:event_txEmailFournisseur3CaretUpdate

    private void txtTelephoneClientCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelephoneClientCaretUpdate
        // TODO add your handling code here:
        TelephonePat(txtTelephoneClient, btnValiderVente, lblMessageClient);

    }//GEN-LAST:event_txtTelephoneClientCaretUpdate

    private void txtTelephoneRechEmployeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelephoneRechEmployeCaretUpdate
        // TODO add your handling code here:
        TelephonePat(txtTelephoneRechEmploye, btnModifierEmploye, lblMessageEmployeModifier);
    }//GEN-LAST:event_txtTelephoneRechEmployeCaretUpdate

    private void txtTelephoneRechEmploye1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelephoneRechEmploye1CaretUpdate
        // TODO add your handling code here:
        TelephonePat(txtTelephoneRechEmploye1, btnModifierEmploye, lblMessageEmployeModifier);
    }//GEN-LAST:event_txtTelephoneRechEmploye1CaretUpdate

    private void txTelephoneFournisseur2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txTelephoneFournisseur2CaretUpdate
        // TODO add your handling code here:
        TelephonePat(txTelephoneFournisseur2, btModifierFournisseur, lblMessageModifierFournisseur);
    }//GEN-LAST:event_txTelephoneFournisseur2CaretUpdate

    private void txtTelephoneRechFourni1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelephoneRechFourni1CaretUpdate
        // TODO add your handling code here:
        TelephonePat(txtTelephoneRechFourni1, btModifierFournisseur, lblMessageModifierFournisseur);

    }//GEN-LAST:event_txtTelephoneRechFourni1CaretUpdate

    private void txtTelephoneRechFourni2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelephoneRechFourni2CaretUpdate
        // TODO add your handling code here:
        TelephonePat(txtTelephoneRechFourni2, btModifierFournisseur, lblMessageModifierFournisseur);

    }//GEN-LAST:event_txtTelephoneRechFourni2CaretUpdate

    private void txTelephoneFournisseurCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txTelephoneFournisseurCaretUpdate
        // TODO add your handling code here:
        TelephonePat(txTelephoneFournisseur, btnajouterFournisseur, lblMessageFournisseur);
    }//GEN-LAST:event_txTelephoneFournisseurCaretUpdate

    private void txTelephoneFournisseur1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txTelephoneFournisseur1CaretUpdate
        // TODO add your handling code here:
        TelephonePat(txTelephoneFournisseur1, btnajouterFournisseur, lblMessageFournisseur);
    }//GEN-LAST:event_txTelephoneFournisseur1CaretUpdate

    private void txtTelephoneFourni2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelephoneFourni2CaretUpdate
        // TODO add your handling code here:
        TelephonePat(txtTelephoneFourni2, btnajouterFournisseur, lblMessageFournisseur);
    }//GEN-LAST:event_txtTelephoneFourni2CaretUpdate

    private void txtTelephoneEmployeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelephoneEmployeCaretUpdate
        // TODO add your handling code here:
        TelephonePat(txtTelephoneEmploye, btnenregistrerEmploye, lblMessageEmploye);

    }//GEN-LAST:event_txtTelephoneEmployeCaretUpdate

    private void txtTelephoneEmploye1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelephoneEmploye1CaretUpdate
        // TODO add your handling code here:
        TelephonePat(txtTelephoneEmploye1, btnenregistrerEmploye, lblMessageEmploye);
    }//GEN-LAST:event_txtTelephoneEmploye1CaretUpdate

    private void btnEffectuerPayrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEffectuerPayrollActionPerformed
        // TODO add your handling code here:
        String moispayroll = cbxMoisPayroll.getSelectedItem().toString();
        int j = 0;
        int i = JOptionPane.showConfirmDialog(null, "Etes vous sur de vouloir preparer le payroll " + Nomutilisateur + "?", "Confirmer", 2);
        if (i == 0) {

            try {
                String code = SysGestBricoLocalClient.pay.codePayroll();
                while (GrillePreparerPayroll.getRowCount() > j) {
                    //mont+=Float.valueOf(GrillePreparerPayroll.getValueAt(i, 3).toString());
                    String pay = SysGestBricoLocalClient.pay.AjouterPayroll(code, GrillePreparerPayroll.getValueAt(j, 0).toString(), GrillePreparerPayroll.getValueAt(j, 6).toString(), "", Float.valueOf(GrillePreparerPayroll.getValueAt(j, 4).toString()),ser.annee);
                    j++;
                }
                if (j != 0) {
                    JOptionPane.showMessageDialog(null, "Payroll prepare avec succes pour le mois " + cbxMoisPayroll.getSelectedItem().toString() + "le numero est:" + code);
                    
                }
                j = 0;

            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnEffectuerPayrollActionPerformed

    private void btnAfficherPayrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfficherPayrollActionPerformed
        // TODO add your handling code here:
        SysGestBricoLocalClient.ListerPayroll(entetePayrollLister, grilleRechPayroll);
    }//GEN-LAST:event_btnAfficherPayrollActionPerformed

    private void cbxRechMoisPayrollItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxRechMoisPayrollItemStateChanged
        // TODO add your handling code here:
        String rech = cbxRechMoisPayroll.getSelectedItem().toString();
        Boolean trouve = false;
        try {
            SysGestBricoLocalClient.ListerPayrollParIndice(entetePayrollLister, grilleRechPayroll, rech);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxRechMoisPayrollItemStateChanged

    private void cbxRechDatePayrollItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxRechDatePayrollItemStateChanged
        // TODO add your handling code here:
        String rech = cbxRechDatePayroll.getSelectedItem().toString();
        Boolean trouve = false;
        try {
            SysGestBricoLocalClient.ListerPayrollParIndice(entetePayrollLister, grilleRechPayroll, rech);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxRechDatePayrollItemStateChanged

    private void txtMotdemasseConnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMotdemasseConnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMotdemasseConnActionPerformed
//SysGestBricoLocalClient.AjouterLigneVente(teteVente, grilleVente);

    public static Object[][] LigneVente() {
        Object[][] data = null;
        try {
            int j = 0;
            int i = 0;
            data = new Object[cbxvt.getItemCount()][7];
            for (j = 0; j < cbxvt.getItemCount(); j++) {

                while (i < cbxvt.getItemCount()) {
                    String r[] = cbxvt.getItemAt(i).toString().split(";");
                    data[i][0] = r[0];
                    data[i][1] = r[1];
                    data[i][2] = r[2];
                    data[i][3] = r[3];
                    data[i][4] = r[4];
                    data[i][5] = r[5];
                    data[i][6] = i;
                    cbxRetirerArticleVente.addItem(i);
                    i++;

                }
            }
            i = 0;
            j = 0;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());

        }
        return data;
    }

    public static void AjouterLigneVente(String tete[], JTable tableau) {

        try {

            datap = LigneVente();
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Prod tenten! " + ex.getMessage(), "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void EmailPat(JTextField champ, JButton bouton, JLabel label) {
        final char car = '.';
        String ch;
        ch = champ.getText();
        int nbCar = 0;
        int nbC = 0;
        try {
            if (ch.charAt(0) == '@' || (ch.charAt(1) == '@') || (ch.charAt(2) == '@')) {
                //JOptionPane.showMessageDialog(null, "Mail mal debute");
                label.setText("Erreur de saisie: Mail incorrect");
                bouton.setEnabled(false);
            }
            for (int i = 0; i < ch.length(); i++) {
                if (ch.charAt(i) == '@') {
                    nbC++;
                    if (nbC > 1) {
                        //JOptionPane.showMessageDialog(null, "Mail incorrect");
                        label.setText("Erreur de saisie: Mail incorrect");
                        bouton.setEnabled(false);
                    }
                }
                if (ch.charAt(i) == car) {
                    nbCar++;

                    if (nbCar > 1) {
                        JOptionPane.showMessageDialog(null, "Mail incorrect");
                        label.setText("Erreur de saisie: Mail incorrect");
                        bouton.setEnabled(false);
                    }
                    if (nbCar == 1 && nbC == 1) {
                        label.setText("");
                        bouton.setEnabled(true);
                    }

                }
            }

        } catch (Exception e) {
        }
    }

    public static void TelephonePat(JTextField champ, JButton bouton, JLabel label) {
        try {
            int num = Integer.valueOf(champ.getText());

            if (champ.getText().charAt(0) != '3' && (champ.getText().charAt(0) != '4')) {
                label.setText("Debut telephone non valide!");
                bouton.setEnabled(false);
            }
            if (champ.getText().length() < 8 || (champ.getText().length() > 8)) {
                label.setText("Telephone non valide!");
                bouton.setEnabled(false);

            } else {
                label.setText("T");
                bouton.setEnabled(true);
            }

        } catch (NumberFormatException e) {
            label.setText("caractere non valide pour telephone:" + e.getMessage());
            bouton.setEnabled(false);
        }
    }

    public static void ChargercomboFevrier(JComboBox combo) {
        // janvier, fevrier, mars, avril, mai, juin, juillet, aout, septembre, octobre, novembre, decembre
        combo.removeAllItems();
        combo.addItem("janvier");
        combo.addItem("janvier");
        combo.addItem("janvier");



    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Achat;
    private javax.swing.JPanel Article;
    public javax.swing.JMenuBar BMnMenuPrincipal;
    private javax.swing.JButton BtAjouterArticle;
    private javax.swing.JButton BtBloquerUtilisateur;
    private javax.swing.JButton BtDebloquerUtilisateur;
    private javax.swing.JButton BtModifierArticle;
    private javax.swing.JButton BtSupprimerArticle;
    private javax.swing.JTabbedPane Categorie;
    private static javax.swing.JComboBox CbCategorieAjouterArticle;
    private static javax.swing.JComboBox CbCategorieArticleModifier;
    static javax.swing.JTabbedPane Employe;
    private static javax.swing.JTabbedPane Fournisseur;
    private static javax.swing.JTable GrilleAffichervente;
    private javax.swing.JTable GrilleEtatUtilisateur;
    private javax.swing.JTable GrillePreparerPayroll;
    private static javax.swing.JTable Grillerechvente;
    private javax.swing.JTable JtChagerDepartement;
    private javax.swing.JLabel LblMessageCategorie;
    public static javax.swing.JMenu MnVente;
    private javax.swing.JTabbedPane Outils;
    private javax.swing.JPanel PanListerFournisseur;
    private javax.swing.JPanel PanRechercherUtilisateur;
    private javax.swing.JTabbedPane Payroll;
    private javax.swing.JTabbedPane TbAjouterArticle;
    public static javax.swing.JTabbedPane TbArticle;
    private static javax.swing.JPasswordField TxtNouveauMotPasse;
    private static javax.swing.JTabbedPane Utilisateur;
    private javax.swing.JTabbedPane Vente;
    private javax.swing.JToolBar barreoutils;
    private javax.swing.JButton btAjouterCategorie;
    public javax.swing.JButton btModifierCategorie;
    private javax.swing.JButton btModifierFournisseur;
    public javax.swing.JButton btSupprimerCategorie;
    private javax.swing.JButton btnAchat;
    private javax.swing.JButton btnAfficherEmploye;
    private javax.swing.JButton btnAfficherPayroll;
    private javax.swing.JButton btnAjouterDepartement;
    private javax.swing.JButton btnAjouterLigneVente;
    private javax.swing.JButton btnAjouterUtilisateur;
    private javax.swing.JButton btnArticle;
    private javax.swing.JButton btnCategorie;
    private javax.swing.JButton btnChagerMotPasseUt;
    private javax.swing.JButton btnConnecter;
    private javax.swing.JButton btnDeconnecter;
    private javax.swing.JButton btnEffectuerPayroll;
    private javax.swing.JButton btnEmploye;
    private javax.swing.JButton btnEnregistrerFonction1;
    private javax.swing.JButton btnFournisseur;
    private javax.swing.JButton btnListerUtilisateur;
    private javax.swing.JButton btnMenuDroite;
    private javax.swing.JButton btnMenuGauche;
    private javax.swing.JButton btnMenuHaut;
    private javax.swing.JButton btnModifierAchat;
    private javax.swing.JButton btnModifierDepartement;
    private javax.swing.JButton btnModifierEmploye;
    private javax.swing.JButton btnModifierFonction1;
    private javax.swing.JButton btnModifierMotPasse;
    private javax.swing.JButton btnModifierTaxe;
    private javax.swing.JButton btnModifierUtilisateur;
    private javax.swing.JButton btnOutil;
    private javax.swing.JButton btnPayroll;
    private javax.swing.JButton btnQuitterApplication;
    private javax.swing.JButton btnQuitterConnexion;
    private javax.swing.JButton btnRechercherEmp;
    private javax.swing.JButton btnRechercherEmployerUtil;
    private javax.swing.JButton btnRechercherMotdepasse;
    private javax.swing.JButton btnRetirerArticleVente;
    private javax.swing.JButton btnSupprimerAchat;
    private javax.swing.JButton btnSupprimerDepartement;
    private javax.swing.JButton btnSupprimerEmploye;
    private javax.swing.JButton btnSupprimerFonction1;
    private javax.swing.JButton btnSupprimerFournisseur;
    private javax.swing.JButton btnTraceUtilisateur;
    private javax.swing.JButton btnValiderVente;
    private javax.swing.JButton btnVente;
    private javax.swing.JButton btnVenteVente;
    private javax.swing.JButton btnajouterFournisseur;
    private javax.swing.JButton btnenregistrerAchat;
    private javax.swing.JButton btnenregistrerEmploye;
    public static javax.swing.JComboBox cbDescriptionArticleModifier;
    private static javax.swing.JComboBox cbEtatUtilisateur;
    private static javax.swing.JComboBox cbEtatUtilisateurRechercher;
    private static javax.swing.JComboBox cbFonctionMod1;
    private static javax.swing.JComboBox cbFournisseurARech;
    private static javax.swing.JComboBox cbFournisseurAchat;
    private static javax.swing.JComboBox cbFournisseurAjouterArticle;
    public static javax.swing.JComboBox cbFournisseurSupprimer1;
    public static javax.swing.JComboBox cbRechercherDateAjout;
    public static javax.swing.JComboBox cbRechercherDateAjoutAchat;
    public static javax.swing.JComboBox cbRechercherDateAjoutCAtegorie;
    public static javax.swing.JComboBox cbRechercherDescCategorie;
    public static javax.swing.JComboBox cbRechercherDescription;
    private static javax.swing.JComboBox cbRechercherDescriptionAchat;
    public static javax.swing.JComboBox cbRecherchersupprimerDescription;
    public static javax.swing.JComboBox cbRecherchersupprimerNumeroArt;
    private static javax.swing.JComboBox cbRoleUtilisateur;
    private static javax.swing.JComboBox cbRoleUtilisateurRechecher;
    static javax.swing.JComboBox cbSexeRechEmploye;
    static javax.swing.JComboBox cbxAffectationEmploye;
    static javax.swing.JComboBox cbxAffectationRechEmploye;
    static javax.swing.JComboBox cbxAnneeEmbaucheEmploye;
    static javax.swing.JComboBox cbxAnneeEmbaucheRechEmploye;
    static javax.swing.JComboBox cbxAnneeNaisEmploye;
    static javax.swing.JComboBox cbxAnneeNaisRechEmploye;
    public static javax.swing.JComboBox cbxEtatConnexionUtilisateurRechercher;
    public static javax.swing.JComboBox cbxEtatUtilisateurRechercher;
    static javax.swing.JComboBox cbxFonctionEmploye;
    static javax.swing.JComboBox cbxFonctionRechEmploye;
    static javax.swing.JComboBox cbxJourEmbaucheEmploye;
    static javax.swing.JComboBox cbxJourEmbaucheRechEmploye;
    static javax.swing.JComboBox cbxJourNaisEmploye;
    static javax.swing.JComboBox cbxJourNaisRechEmploye;
    private static javax.swing.JComboBox cbxLibelleArticleVente;
    private static javax.swing.JComboBox cbxLigneVente;
    private static javax.swing.JComboBox cbxModifierDepartement;
    static javax.swing.JComboBox cbxMoisEmbaucheEmploye;
    static javax.swing.JComboBox cbxMoisEmbaucheRechEmploye;
    static javax.swing.JComboBox cbxMoisNaisEmploye;
    static javax.swing.JComboBox cbxMoisNaisRechEmploye;
    private javax.swing.JComboBox cbxMoisPayroll;
    public static javax.swing.JComboBox cbxNomUtilisateurRechercher;
    public static javax.swing.JComboBox cbxNumeroEmployeCharger;
    private static javax.swing.JComboBox cbxRechDatePayroll;
    private static javax.swing.JComboBox cbxRechMoisPayroll;
    static javax.swing.JComboBox cbxRechercherEmploye;
    public static javax.swing.JComboBox cbxRechercherNomFournisseur;
    public static javax.swing.JComboBox cbxRechercherNumeroFournisseur;
    public static javax.swing.JComboBox cbxRechercherUtilisateurDB;
    public static javax.swing.JComboBox cbxRechercherUtilisateurNom;
    private static javax.swing.JComboBox cbxRetirerArticleVente;
    static javax.swing.JComboBox cbxSalaireEmploye;
    static javax.swing.JComboBox cbxSalaireRechEmploye;
    static javax.swing.JComboBox cbxSexeEmploye;
    public static javax.swing.JComboBox cbxroleUtilisateurRechercher;
    private static javax.swing.JComboBox cbxvt;
    private javax.swing.JTable grilleAchat1;
    private static javax.swing.JTable grilleFournisseur2;
    private static javax.swing.JTable grilleRechEmploye;
    private javax.swing.JTable grilleRechPayroll;
    private javax.swing.JTable grilleUtilisateur1;
    private javax.swing.JTable grilleUtilisateur2;
    private static javax.swing.JTable grilleVente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private static javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JScrollPane jScrollPane44;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JToolBar.Separator jSeparator19;
    private javax.swing.JToolBar.Separator jSeparator20;
    private javax.swing.JToolBar.Separator jSeparator21;
    private javax.swing.JToolBar.Separator jSeparator22;
    private javax.swing.JToolBar.Separator jSeparator23;
    private javax.swing.JToolBar.Separator jSeparator24;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator38;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField1;
    private static javax.swing.JTable jtChargerArticle;
    private static javax.swing.JTable jtChargerCategorie;
    private static javax.swing.JTable jtChargerDatePayrolll;
    private static javax.swing.JTable jtChargerDateVente;
    private static javax.swing.JTable jtChargerFonction;
    private static javax.swing.JTable jtChargerFournisseur;
    private static javax.swing.JTable jtChargerMoisPayroll;
    private static javax.swing.JTable jtChargerNumEmploye;
    private static javax.swing.JTable jtChargerNumeroVente;
    private static javax.swing.JTable jtChargerUtilisateur;
    private static javax.swing.JTable jtChargerVendeur;
    private static javax.swing.JTable jtListerCategorie;
    private static javax.swing.JTable jtRechEmployeUtil;
    private static javax.swing.JTable jtTracee;
    private static javax.swing.JTable jtTraceeAction;
    private static javax.swing.JTable jtTraceeDate;
    private static javax.swing.JTable jtTraceeNomutilisateur;
    private static javax.swing.JTable jtTraceeTableAffectee;
    private static javax.swing.JTable jtgrilleNom;
    private static javax.swing.JTable jtgrilleNomArticle;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label14;
    private javax.swing.JLabel lbMessageMessageUtil1;
    private javax.swing.JLabel lbMessageUtilisateurRech;
    private static javax.swing.JLabel lblDateEmbauche;
    private static javax.swing.JLabel lblDateNais;
    private javax.swing.JLabel lblMessageClient;
    private javax.swing.JLabel lblMessageConn;
    private javax.swing.JLabel lblMessageEmploye;
    private javax.swing.JLabel lblMessageEmployeModifier;
    private javax.swing.JLabel lblMessageFournisseur;
    private javax.swing.JLabel lblMessageModifierFournisseur;
    private javax.swing.JLabel lblMessagePayroll;
    private javax.swing.JLabel lblMessageUtilisateur;
    private javax.swing.JLabel lblMessageUtilisateur1;
    private java.awt.Label lblMessageVente;
    private javax.swing.JLabel lblMontantTotalPayroll;
    private javax.swing.JLabel lblNomUtilisateur;
    private static java.awt.Label lblNombreArticleVente;
    private javax.swing.JLabel lblNombreEmployeCharger;
    private javax.swing.JLabel lblPied;
    private javax.swing.JLabel lblPied1;
    private javax.swing.JLabel lblPied2;
    private static java.awt.Label lblPrixtotalvente;
    private javax.swing.JLabel lblTeteConnexion;
    private javax.swing.JLabel lblTeteDepartement;
    private static javax.swing.JLabel lblTotalEmploye;
    private static javax.swing.JLabel lblUtilisateurconnecter;
    private javax.swing.JLabel lblcategorie;
    private javax.swing.JLabel lblcategorie3;
    private javax.swing.JLabel lblcategorie4;
    private javax.swing.JLabel lblcodearticle;
    private javax.swing.JLabel lblcodearticle1;
    private javax.swing.JLabel lblcodearticle10;
    private javax.swing.JLabel lblcodearticle11;
    private javax.swing.JLabel lblcodearticle12;
    private javax.swing.JLabel lblcodearticle13;
    private javax.swing.JLabel lblcodearticle14;
    private javax.swing.JLabel lblcodearticle15;
    private javax.swing.JLabel lblcodearticle16;
    private javax.swing.JLabel lblcodearticle17;
    private javax.swing.JLabel lblcodearticle18;
    private javax.swing.JLabel lblcodearticle19;
    private javax.swing.JLabel lblcodearticle20;
    private javax.swing.JLabel lblcodearticle22;
    private javax.swing.JLabel lblcodearticle25;
    private javax.swing.JLabel lblcodearticle26;
    private javax.swing.JLabel lblcodearticle27;
    private javax.swing.JLabel lblcodearticle28;
    private javax.swing.JLabel lblcodearticle29;
    private javax.swing.JLabel lblcodearticle3;
    private javax.swing.JLabel lblcodearticle30;
    private javax.swing.JLabel lblcodearticle32;
    private javax.swing.JLabel lblcodearticle34;
    private javax.swing.JLabel lblcodearticle36;
    private javax.swing.JLabel lblcodearticle37;
    private javax.swing.JLabel lblcodearticle38;
    private javax.swing.JLabel lblcodearticle39;
    private javax.swing.JLabel lblcodearticle4;
    private javax.swing.JLabel lblcodearticle40;
    private javax.swing.JLabel lblcodearticle41;
    private javax.swing.JLabel lblcodearticle42;
    private javax.swing.JLabel lblcodearticle43;
    private javax.swing.JLabel lblcodearticle6;
    private javax.swing.JLabel lblcodearticle7;
    private javax.swing.JLabel lblcodearticle8;
    private javax.swing.JLabel lblcodearticle9;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblemail1;
    private javax.swing.JLabel lblemail11;
    private javax.swing.JLabel lblemail12;
    private javax.swing.JLabel lblemail14;
    private javax.swing.JLabel lblemail15;
    private javax.swing.JLabel lblemail3;
    private javax.swing.JLabel lblemail4;
    private javax.swing.JLabel lblemail5;
    private javax.swing.JLabel lblemail6;
    private javax.swing.JLabel lblemail7;
    private javax.swing.JLabel lblemail8;
    private javax.swing.JLabel lblerreurnomarticle;
    private javax.swing.JLabel lblerreurnomarticle10;
    private javax.swing.JLabel lblerreurnomarticle11;
    private javax.swing.JLabel lblerreurnomarticle12;
    private javax.swing.JLabel lblerreurnomarticle14;
    private javax.swing.JLabel lblerreurnomarticle15;
    private javax.swing.JLabel lblerreurnomarticle16;
    private javax.swing.JLabel lblerreurnomarticle17;
    private javax.swing.JLabel lblerreurnomarticle2;
    private javax.swing.JLabel lblerreurnomarticle3;
    private javax.swing.JLabel lblerreurnomarticle4;
    private javax.swing.JLabel lblerreurnomarticle6;
    private javax.swing.JLabel lblerreurnomarticle7;
    private javax.swing.JLabel lblerreurnomarticle8;
    private javax.swing.JLabel lblerreurnomarticle9;
    private javax.swing.JLabel lblerreurprixarticle10;
    private javax.swing.JLabel lblerreurprixarticle11;
    private javax.swing.JLabel lblerreurprixarticle2;
    private javax.swing.JLabel lblerreurprixarticle3;
    private javax.swing.JLabel lblerreurprixarticle4;
    private javax.swing.JLabel lblerreurprixarticle9;
    private javax.swing.JLabel lblnomarticle;
    private javax.swing.JLabel lblnomarticle1;
    private javax.swing.JLabel lblnomarticle10;
    private javax.swing.JLabel lblnomarticle11;
    private javax.swing.JLabel lblnomarticle12;
    private javax.swing.JLabel lblnomarticle13;
    private javax.swing.JLabel lblnomarticle14;
    private javax.swing.JLabel lblnomarticle15;
    private javax.swing.JLabel lblnomarticle16;
    private javax.swing.JLabel lblnomarticle17;
    private javax.swing.JLabel lblnomarticle18;
    private javax.swing.JLabel lblnomarticle19;
    private javax.swing.JLabel lblnomarticle20;
    private javax.swing.JLabel lblnomarticle21;
    private javax.swing.JLabel lblnomarticle22;
    private javax.swing.JLabel lblnomarticle23;
    private javax.swing.JLabel lblnomarticle24;
    private javax.swing.JLabel lblnomarticle27;
    private javax.swing.JLabel lblnomarticle28;
    private javax.swing.JLabel lblnomarticle29;
    private javax.swing.JLabel lblnomarticle30;
    private javax.swing.JLabel lblnomarticle4;
    private javax.swing.JLabel lblnomarticle5;
    private javax.swing.JLabel lblnomarticle6;
    private javax.swing.JLabel lblnomarticle7;
    private javax.swing.JLabel lblnomarticle8;
    private javax.swing.JLabel lblnomarticle9;
    private javax.swing.JLabel lbltelephonefournissuer;
    private javax.swing.JLabel lbltelephonefournissuer1;
    private javax.swing.JLabel lbltelephonefournissuer11;
    private javax.swing.JLabel lbltelephonefournissuer12;
    private javax.swing.JLabel lbltelephonefournissuer15;
    private javax.swing.JLabel lbltelephonefournissuer3;
    private javax.swing.JLabel lbltelephonefournissuer4;
    private javax.swing.JLabel lbltelephonefournissuer5;
    private javax.swing.JLabel lbltelephonefournissuer6;
    private javax.swing.JLabel lbltelephonefournissuer7;
    private javax.swing.JLabel lbltelephonefournissuer8;
    public static javax.swing.JMenu mnAchat;
    public static javax.swing.JMenu mnArticle;
    public static javax.swing.JMenu mnCategorie;
    public static javax.swing.JMenu mnEmploye;
    public static javax.swing.JMenu mnFournisseur;
    public static javax.swing.JMenu mnOutil;
    public static javax.swing.JMenu mnPayroll;
    public static javax.swing.JMenu mnUtilisateur;
    private javax.swing.JPanel panAfficherArticleStock;
    private javax.swing.JPanel panAfficherVente;
    private javax.swing.JPanel panAjouterArtcile;
    private javax.swing.JPanel panAjouterFournisseur;
    private javax.swing.JPanel panAjouterFournisseur1;
    private javax.swing.JPanel panAjouterFournisseur2;
    private javax.swing.JPanel panAjouterUtilisateur;
    private javax.swing.JPanel panArticle;
    private javax.swing.JPanel panChangerMotpasse;
    private javax.swing.JPanel panConnexion;
    public javax.swing.JPanel panCorpsAchat;
    private static javax.swing.JPanel panCorpsAchatRech;
    public javax.swing.JPanel panCorpsAjouterProduit;
    public javax.swing.JPanel panCorpsAjouterProduit2;
    public javax.swing.JPanel panCorpsAjouterProduit3;
    public javax.swing.JPanel panCorpsAjouterProduit4;
    public javax.swing.JPanel panCorpsCategorie;
    public static javax.swing.JPanel panCorpsConnexion;
    public javax.swing.JPanel panCorpsEffectuerVente3;
    public javax.swing.JPanel panCorpsEmploye;
    public javax.swing.JPanel panCorpsEnregistrerUtil;
    public javax.swing.JPanel panCorpsEnregistrerUtil1;
    public javax.swing.JPanel panCorpsFournisseur;
    public javax.swing.JPanel panCorpsFournisseur1;
    public javax.swing.JPanel panCorpsOutilsEmploye2;
    public javax.swing.JPanel panCorpsRechEmpl;
    public javax.swing.JPanel panCorpsRechUtilisateur;
    public javax.swing.JPanel panCorpsRechUtilisateur1;
    private javax.swing.JPanel panEffectuerPayroll;
    private javax.swing.JPanel panEffectuerVente;
    private javax.swing.JPanel panEmbaucherEmploye;
    private javax.swing.JPanel panEnregistrerAchat;
    private javax.swing.JPanel panEtatUtilisateur;
    private javax.swing.JPanel panFourniss;
    private javax.swing.JPanel panHistorique;
    private javax.swing.JPanel panListerUtilisateur;
    private javax.swing.JPanel panModifierEmploye;
    private javax.swing.JPanel panPrelevement1;
    private javax.swing.JPanel panPreparerPaiement1;
    private javax.swing.JPanel panRechEmpl1;
    private javax.swing.JPanel panRechEmpl2;
    private javax.swing.JPanel panRechPayroll;
    private javax.swing.JPanel panRechUtilisateur;
    private javax.swing.JPanel panRechUtilisateurMod;
    private javax.swing.JPanel panRechercherAchat;
    private javax.swing.JPanel panRechercherArticle;
    private javax.swing.JPanel panRechercherCategorie;
    private javax.swing.JPanel panRechercherVente;
    private javax.swing.JPanel panRecherchercherFournisseur;
    private javax.swing.JPanel panSaisieArticle;
    private javax.swing.JPanel panSupprimerArticle;
    public static javax.swing.JPanel panTete;
    public static javax.swing.JPanel panpiedImage;
    private javax.swing.JPanel panrechVente;
    private javax.swing.JPanel pantetepayroll;
    private static javax.swing.JTable tbArticleRechercher;
    private static javax.swing.JTable tbListerArticle;
    private static javax.swing.JTextPane txAdresseFournisseur1;
    static javax.swing.JTextField txAdresseRechEmploye;
    private static javax.swing.JTextField txCategorieArticleSupprimer;
    private static javax.swing.JTextField txDescriptionAchat;
    private static javax.swing.JTextField txDescriptionAchatRech;
    private static javax.swing.JTextField txEmailEmploye;
    private static javax.swing.JTextField txEmailEmploye1;
    private static javax.swing.JTextField txEmailFournisseur1;
    private static javax.swing.JTextField txEmailFournisseur2;
    private static javax.swing.JTextField txEmailFournisseur3;
    private static javax.swing.JTextField txEmailFournisseur4;
    private static javax.swing.JTextField txEmailFournisseur5;
    private static javax.swing.JTextField txFournisseurArticleSupprimer;
    private static javax.swing.JTextField txFraisAchat;
    private static javax.swing.JTextField txFraisAchatRech;
    private static javax.swing.JTextField txMontantRecu;
    static javax.swing.JTextField txNomRechEmploye;
    static javax.swing.JTextField txPrenomRechEmploye;
    private static javax.swing.JTextField txPrixArticleModifier;
    private static javax.swing.JTextField txPrixArticleSupprimer;
    private static javax.swing.JTextField txQuantiteArticleModifier;
    private static javax.swing.JTextField txQuantiteArticleSupprimer;
    private static javax.swing.JTextField txTelephoneFournisseur;
    private static javax.swing.JTextField txTelephoneFournisseur1;
    private static javax.swing.JTextField txTelephoneFournisseur2;
    private static javax.swing.JTextField txtAdresseClient;
    static javax.swing.JTextField txtAdresseEmploye;
    private static javax.swing.JTextField txtAdresselFournisseur;
    private static javax.swing.JTextField txtAjouterDepartement;
    private static javax.swing.JPasswordField txtAncienMotDePasse;
    private static javax.swing.JTextPane txtCategorie;
    private static javax.swing.JTextPane txtCategorieRechercher;
    private static javax.swing.JTextPane txtDescriptionArticle;
    private static javax.swing.JTextPane txtDescriptionArticleModifier;
    private static javax.swing.JTextPane txtDescriptionArticleSupprimer;
    private static javax.swing.JTextField txtEmailClient;
    static javax.swing.JTextField txtEmailRechEmploye;
    static javax.swing.JTextField txtEmailRechEmploye1;
    private static javax.swing.JTextField txtEmaillFournisseur;
    private static javax.swing.JTextField txtEtatUtilisateurRechEtat;
    private static javax.swing.JTextField txtFonction1;
    private static javax.swing.JTextField txtIndiceRechercheEmployeUtil;
    private javax.swing.JTextField txtIndiceTracee;
    static javax.swing.JTextField txtMatriculeEmploye;
    static javax.swing.JTextField txtMatriculeRechEmploye;
    private static javax.swing.JPasswordField txtModPasseRechercherMotdepasse;
    private static javax.swing.JTextPane txtModifierDepartement;
    private static javax.swing.JTextField txtMort;
    private static javax.swing.JPasswordField txtMotPasseUtilRech;
    private static javax.swing.JPasswordField txtMotPasseUtililisateur;
    private javax.swing.JPasswordField txtMotdemasseConn;
    private static javax.swing.JTextField txtNomClient;
    static javax.swing.JTextField txtNomEmploye;
    private static javax.swing.JTextField txtNomFournisseur;
    private static javax.swing.JTextField txtNomFournisseur1;
    private static javax.swing.JTextField txtNomUtilisateur;
    private javax.swing.JTextField txtNomUtilisateurConn;
    private static javax.swing.JTextField txtNomUtilisateurRech;
    private static javax.swing.JTextField txtNomUtilisateurRechEtat;
    private static javax.swing.JTextField txtNomUtilisateurRechercherMotdepasse;
    private static javax.swing.JPasswordField txtNouveauMotPasserepeter;
    private static javax.swing.JTextField txtNumeroCategorieRechercher;
    private static javax.swing.JTextField txtNumeroVenteArticle;
    private static javax.swing.JTextField txtOna;
    static javax.swing.JTextField txtPrenomEmploye;
    private static javax.swing.JTextField txtPrixAchat;
    private static javax.swing.JTextField txtPrixAchatRech;
    private static javax.swing.JTextField txtPrixArticle;
    private static javax.swing.JTextField txtPrixArticleVente;
    private static javax.swing.JTextField txtQuantiteAchat;
    private static javax.swing.JTextField txtQuantiteAchatRech;
    private static javax.swing.JTextField txtQuantiteArticle;
    private static javax.swing.JTextField txtQuantiteArticleVente;
    private static javax.swing.JTextField txtQuantiteEmploye;
    private static javax.swing.JTextField txtQuantiteEmployeMod1;
    private static javax.swing.JTextField txtRechercherEmployerIndice;
    private static javax.swing.JTextField txtRechercherUtilisateur;
    private static javax.swing.JPasswordField txtRepeterMotpasseUtilRech;
    private static javax.swing.JPasswordField txtRepeterMotpasseUtilisateur;
    private static javax.swing.JTextField txtRoleUtilisateurRechEtat;
    private static javax.swing.JTextField txtSalairemax;
    private static javax.swing.JTextField txtSalairemax3;
    private static javax.swing.JTextField txtSalairemin;
    private static javax.swing.JTextField txtSalairemin3;
    private static javax.swing.JTextField txtSante;
    private static javax.swing.JTextField txtTca;
    private static javax.swing.JTextField txtTelephoneClient;
    private static javax.swing.JTextField txtTelephoneEmploye;
    private static javax.swing.JTextField txtTelephoneEmploye1;
    private static javax.swing.JTextField txtTelephoneFourni2;
    static javax.swing.JTextField txtTelephoneRechEmploye;
    static javax.swing.JTextField txtTelephoneRechEmploye1;
    private static javax.swing.JTextField txtTelephoneRechFourni1;
    private static javax.swing.JTextField txtTelephoneRechFourni2;
    private static javax.swing.JTextField txtVie;
    // End of variables declaration//GEN-END:variables
}

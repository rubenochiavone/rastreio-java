package rastreio;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrackObjectServiceTypeTest {
  @Test
  public void testEnumValues() {
    TrackObjectServiceType serviceType;

    serviceType = TrackObjectServiceType.AA;
    assertEquals("AA", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.AB;
    assertEquals("AB", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.AL;
    assertEquals("AL", serviceType.getInitials());
    assertEquals("AGENTES DE LEITURA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.AR;
    assertEquals("AR", serviceType.getInitials());
    assertEquals("AVISO DE RECEBIMENTO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.AS;
    assertEquals("AS", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC - ACAO SOCIAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.BE;
    assertEquals("BE", serviceType.getInitials());
    assertEquals("REMESSA ECONÔMICA S/ AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.BF;
    assertEquals("BF", serviceType.getInitials());
    assertEquals("REMESSA EXPRESSA S/ AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.BG;
    assertEquals("BG", serviceType.getInitials());
    assertEquals("ETIQUETA LOG REM ECON C/AR BG", serviceType.getDescription());

    serviceType = TrackObjectServiceType.BH;
    assertEquals("BH", serviceType.getInitials());
    assertEquals("MENSAGEM FÍSICO-DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.BI;
    assertEquals("BI", serviceType.getInitials());
    assertEquals("ETIQUETA LÓG REGIST URG", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CA;
    assertEquals("CA", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CB;
    assertEquals("CB", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CC;
    assertEquals("CC", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CD;
    assertEquals("CD", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CE;
    assertEquals("CE", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CF;
    assertEquals("CF", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CG;
    assertEquals("CG", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CH;
    assertEquals("CH", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CI;
    assertEquals("CI", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CJ;
    assertEquals("CJ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CK;
    assertEquals("CK", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CL;
    assertEquals("CL", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CM;
    assertEquals("CM", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CN;
    assertEquals("CN", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CO;
    assertEquals("CO", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CP;
    assertEquals("CP", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CQ;
    assertEquals("CQ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CR;
    assertEquals("CR", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CS;
    assertEquals("CS", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CT;
    assertEquals("CT", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CU;
    assertEquals("CU", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CV;
    assertEquals("CV", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CW;
    assertEquals("CW", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CX;
    assertEquals("CX", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CY;
    assertEquals("CY", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.CZ;
    assertEquals("CZ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DA;
    assertEquals("DA", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX C/ AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DB;
    assertEquals("DB", serviceType.getInitials());
    assertEquals("REMESSA EXPRESSA C/ AR DIGITAL-BRADESCO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DC;
    assertEquals("DC", serviceType.getInitials());
    assertEquals("REMESSA EXPRESSA (ORGAO TRANSITO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DD;
    assertEquals("DD", serviceType.getInitials());
    assertEquals("DEVOLUÇÃO DE DOCUMENTOS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DE;
    assertEquals("DE", serviceType.getInitials());
    assertEquals("REMESSA EXPRESSA C/ AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DF;
    assertEquals("DF", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DG;
    assertEquals("DG", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DI;
    assertEquals("DI", serviceType.getInitials());
    assertEquals("REM EXPRES COM AR DIGITAL ITAU", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DJ;
    assertEquals("DJ", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DK;
    assertEquals("DK", serviceType.getInitials());
    assertEquals("SEDEX EXTRA GRANDE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DL;
    assertEquals("DL", serviceType.getInitials());
    assertEquals("SEDEX LÓGICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DM;
    assertEquals("DM", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DN;
    assertEquals("DN", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DO;
    assertEquals("DO", serviceType.getInitials());
    assertEquals("REM EXPRES COM AR DIGITAL ITAU UNIBANCO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DP;
    assertEquals("DP", serviceType.getInitials());
    assertEquals("SEDEX PAGAMENTO ENTREGA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DQ;
    assertEquals("DQ", serviceType.getInitials());
    assertEquals("REM EXPRES COM AR DIGITAL BRADESCO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DR;
    assertEquals("DR", serviceType.getInitials());
    assertEquals("REM EXPRES COM AR DIGITAL SANTANDER", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DS;
    assertEquals("DS", serviceType.getInitials());
    assertEquals("REM EXPRES COM AR DIGITAL SANTANDER", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DT;
    assertEquals("DT", serviceType.getInitials());
    assertEquals("REMESSA ECON.SEG.TRANSITO C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DU;
    assertEquals("DU", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DV;
    assertEquals("DV", serviceType.getInitials());
    assertEquals("SEDEX COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DW;
    assertEquals("DW", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LÓGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DX;
    assertEquals("DX", serviceType.getInitials());
    assertEquals("SEDEX 10 LÓGICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DY;
    assertEquals("DY", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ FÍSICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.DZ;
    assertEquals("DZ", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EA;
    assertEquals("EA", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EB;
    assertEquals("EB", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EC;
    assertEquals("EC", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.ED;
    assertEquals("ED", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PACKET EXPRESS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EE;
    assertEquals("EE", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EF;
    assertEquals("EF", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EG;
    assertEquals("EG", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EH;
    assertEquals("EH", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EI;
    assertEquals("EI", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EJ;
    assertEquals("EJ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EK;
    assertEquals("EK", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EL;
    assertEquals("EL", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EM;
    assertEquals("EM", serviceType.getInitials());
    assertEquals("SEDEX MUNDI", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EN;
    assertEquals("EN", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EO;
    assertEquals("EO", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EP;
    assertEquals("EP", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EQ;
    assertEquals("EQ", serviceType.getInitials());
    assertEquals("ENCOMENDA SERVIÇO NÃO EXPRESSA ECT", serviceType.getDescription());

    serviceType = TrackObjectServiceType.ER;
    assertEquals("ER", serviceType.getInitials());
    assertEquals("REGISTRADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.ES;
    assertEquals("ES", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.ET;
    assertEquals("ET", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EU;
    assertEquals("EU", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EV;
    assertEquals("EV", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EW;
    assertEquals("EW", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EX;
    assertEquals("EX", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EY;
    assertEquals("EY", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.EZ;
    assertEquals("EZ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.FA;
    assertEquals("FA", serviceType.getInitials());
    assertEquals("FAC REGISTRADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.FB;
    assertEquals("FB", serviceType.getInitials());
    assertEquals("FAC REGISTRADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.FC;
    assertEquals("FC", serviceType.getInitials());
    assertEquals("FAC REGISTRADO (5 DIAS)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.FD;
    assertEquals("FD", serviceType.getInitials());
    assertEquals("FAC REGISTRADO (10 DIAS)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.FE;
    assertEquals("FE", serviceType.getInitials());
    assertEquals("ENCOMENDA FNDE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.FF;
    assertEquals("FF", serviceType.getInitials());
    assertEquals("REGISTRADO DETRAN", serviceType.getDescription());

    serviceType = TrackObjectServiceType.FH;
    assertEquals("FH", serviceType.getInitials());
    assertEquals("FAC REGISTRADO C/ AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.FJ;
    assertEquals("FJ", serviceType.getInitials());
    assertEquals("REMESSA ECONÔMICA C/ AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.FM;
    assertEquals("FM", serviceType.getInitials());
    assertEquals("FAC REGISTRADO (MONITORADO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.FR;
    assertEquals("FR", serviceType.getInitials());
    assertEquals("FAC REGISTRADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.IA;
    assertEquals("IA", serviceType.getInitials());
    assertEquals("INTEGRADA AVULSA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.IC;
    assertEquals("IC", serviceType.getInitials());
    assertEquals("INTEGRADA A COBRAR", serviceType.getDescription());

    serviceType = TrackObjectServiceType.ID;
    assertEquals("ID", serviceType.getInitials());
    assertEquals("INTEGRADA DEVOLUCAO DE DOCUMENTO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.IE;
    assertEquals("IE", serviceType.getInitials());
    assertEquals("INTEGRADA ESPECIAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.IF;
    assertEquals("IF", serviceType.getInitials());
    assertEquals("CPF", serviceType.getDescription());

    serviceType = TrackObjectServiceType.II;
    assertEquals("II", serviceType.getInitials());
    assertEquals("INTEGRADA INTERNO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.IK;
    assertEquals("IK", serviceType.getInitials());
    assertEquals("INTEGRADA COM COLETA SIMULTANEA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.IM;
    assertEquals("IM", serviceType.getInitials());
    assertEquals("INTEGRADA MEDICAMENTOS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.IN;
    assertEquals("IN", serviceType.getInitials());
    assertEquals("OBJ DE CORRESP E EMS REC EXTERIOR", serviceType.getDescription());

    serviceType = TrackObjectServiceType.IP;
    assertEquals("IP", serviceType.getInitials());
    assertEquals("INTEGRADA PROGRAMADA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.IR;
    assertEquals("IR", serviceType.getInitials());
    assertEquals("IMPRESSO REGISTRADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.IS;
    assertEquals("IS", serviceType.getInitials());
    assertEquals("INTEGRADA STANDARD", serviceType.getDescription());

    serviceType = TrackObjectServiceType.IT;
    assertEquals("IT", serviceType.getInitials());
    assertEquals("INTEGRADA TERMOLÁBIL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.IU;
    assertEquals("IU", serviceType.getInitials());
    assertEquals("INTEGRADA URGENTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.IX;
    assertEquals("IX", serviceType.getInitials());
    assertEquals("EDEI ENCOMENDA EXPRESSA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JA;
    assertEquals("JA", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JB;
    assertEquals("JB", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JC;
    assertEquals("JC", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JD;
    assertEquals("JD", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA S/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JE;
    assertEquals("JE", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JF;
    assertEquals("JF", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JG;
    assertEquals("JG", serviceType.getInitials());
    assertEquals("REGISTRADO PRIORITÁRIO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JH;
    assertEquals("JH", serviceType.getInitials());
    assertEquals("REGISTRADO PRIORITÁRIO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JI;
    assertEquals("JI", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA S/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JJ;
    assertEquals("JJ", serviceType.getInitials());
    assertEquals("REGISTRADO JUSTIÇA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JK;
    assertEquals("JK", serviceType.getInitials());
    assertEquals("REMESSA ECONÔMICA S/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JL;
    assertEquals("JL", serviceType.getInitials());
    assertEquals("REGISTRADO LÓGICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JM;
    assertEquals("JM", serviceType.getInitials());
    assertEquals("MALA DIRETA POSTAL ESPECIAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JN;
    assertEquals("JN", serviceType.getInitials());
    assertEquals("MALA DIRETA POSTAL ESPECIAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JO;
    assertEquals("JO", serviceType.getInitials());
    assertEquals("REGISTRADO PRIORITÁRIO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JP;
    assertEquals("JP", serviceType.getInitials());
    assertEquals("OBJETO RECEITA FEDERAL (EXCLUSIVO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JQ;
    assertEquals("JQ", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JR;
    assertEquals("JR", serviceType.getInitials());
    assertEquals("REGISTRADO PRIORITÁRIO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JS;
    assertEquals("JS", serviceType.getInitials());
    assertEquals("REGISTRADO LÓGICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JT;
    assertEquals("JT", serviceType.getInitials());
    assertEquals("REGISTRADO URGENTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JU;
    assertEquals("JU", serviceType.getInitials());
    assertEquals("ETIQUETA FÍS REGIST URG", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JV;
    assertEquals("JV", serviceType.getInitials());
    assertEquals("REMESSA ECONÔMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JW;
    assertEquals("JW", serviceType.getInitials());
    assertEquals("CARTA COMERCIAL A FATURAR (5 DIAS)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JX;
    assertEquals("JX", serviceType.getInitials());
    assertEquals("CARTA COMERCIAL A FATURAR (10 DIAS)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JY;
    assertEquals("JY", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA (5 DIAS)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.JZ;
    assertEquals("JZ", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA (10 DIAS)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LA;
    assertEquals("LA", serviceType.getInitials());
    assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LB;
    assertEquals("LB", serviceType.getInitials());
    assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LC;
    assertEquals("LC", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LD;
    assertEquals("LD", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LE;
    assertEquals("LE", serviceType.getInitials());
    assertEquals("LOGÍSTICA REVERSA ECONOMICA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LF;
    assertEquals("LF", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LG;
    assertEquals("LG", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LH;
    assertEquals("LH", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LI;
    assertEquals("LI", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LJ;
    assertEquals("LJ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LK;
    assertEquals("LK", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LL;
    assertEquals("LL", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LM;
    assertEquals("LM", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LN;
    assertEquals("LN", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LP;
    assertEquals("LP", serviceType.getInitials());
    assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LQ;
    assertEquals("LQ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LS;
    assertEquals("LS", serviceType.getInitials());
    assertEquals("LOGISTICA REVERSA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LV;
    assertEquals("LV", serviceType.getInitials());
    assertEquals("LOGISTICA REVERSA EXPRESSA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LW;
    assertEquals("LW", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LX;
    assertEquals("LX", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PACKET ECONOMIC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LY;
    assertEquals("LY", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.LZ;
    assertEquals("LZ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.MA;
    assertEquals("MA", serviceType.getInitials());
    assertEquals("TELEGRAMA - SERVICOS ADICIONAIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.MB;
    assertEquals("MB", serviceType.getInitials());
    assertEquals("TELEGRAMA DE BALCAO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.MC;
    assertEquals("MC", serviceType.getInitials());
    assertEquals("TELEGRAMA FONADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.MD;
    assertEquals("MD", serviceType.getInitials());
    assertEquals("MAQUINA DE FRANQUEAR (LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.ME;
    assertEquals("ME", serviceType.getInitials());
    assertEquals("TELEGRAMA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.MF;
    assertEquals("MF", serviceType.getInitials());
    assertEquals("TELEGRAMA FONADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.MH;
    assertEquals("MH", serviceType.getInitials());
    assertEquals("CARTA VIA INTERNET", serviceType.getDescription());

    serviceType = TrackObjectServiceType.MK;
    assertEquals("MK", serviceType.getInitials());
    assertEquals("TELEGRAMA CORPORATIVO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.MM;
    assertEquals("MM", serviceType.getInitials());
    assertEquals("TELEGRAMA GRANDES CLIENTES", serviceType.getDescription());

    serviceType = TrackObjectServiceType.MP;
    assertEquals("MP", serviceType.getInitials());
    assertEquals("TELEGRAMA PRÉ-PAGO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.MS;
    assertEquals("MS", serviceType.getInitials());
    assertEquals("ENCOMENDA SAUDE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.MT;
    assertEquals("MT", serviceType.getInitials());
    assertEquals("TELEGRAMA VIA TELEMAIL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.MY;
    assertEquals("MY", serviceType.getInitials());
    assertEquals("TELEGRAMA INTERNACIONAL ENTRANTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.MZ;
    assertEquals("MZ", serviceType.getInitials());
    assertEquals("TELEGRAMA VIA CORREIOS ON LINE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.NE;
    assertEquals("NE", serviceType.getInitials());
    assertEquals("TELE SENA RESGATADA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.NX;
    assertEquals("NX", serviceType.getInitials());
    assertEquals("EDEI ENCOMENDA NAO URGENTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.OA;
    assertEquals("OA", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.OB;
    assertEquals("OB", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.OC;
    assertEquals("OC", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.OD;
    assertEquals("OD", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ FÍSICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.OF;
    assertEquals("OF", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.OG;
    assertEquals("OG", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.OH;
    assertEquals("OH", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.OI;
    assertEquals("OI", serviceType.getInitials());
    assertEquals("ETIQUETA LOGICA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PA;
    assertEquals("PA", serviceType.getInitials());
    assertEquals("PASSAPORTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PB;
    assertEquals("PB", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC - NÃO URGENTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PC;
    assertEquals("PC", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC A COBRAR", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PD;
    assertEquals("PD", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PE;
    assertEquals("PE", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC (ETIQUETA FISICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PF;
    assertEquals("PF", serviceType.getInitials());
    assertEquals("PASSAPORTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PG;
    assertEquals("PG", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC (ETIQUETA FISICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PH;
    assertEquals("PH", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC (ETIQUETA LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PI;
    assertEquals("PI", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PJ;
    assertEquals("PJ", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PK;
    assertEquals("PK", serviceType.getInitials());
    assertEquals("PAC EXTRA GRANDE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PL;
    assertEquals("PL", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PM;
    assertEquals("PM", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC (ETIQ FÍSICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PN;
    assertEquals("PN", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PO;
    assertEquals("PO", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PP;
    assertEquals("PP", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PQ;
    assertEquals("PQ", serviceType.getInitials());
    assertEquals("ETIQUETA LOGICA PAC MINI", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PR;
    assertEquals("PR", serviceType.getInitials());
    assertEquals("REEMBOLSO POSTAL - CLIENTE AVULSO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PS;
    assertEquals("PS", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PT;
    assertEquals("PT", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PU;
    assertEquals("PU", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PV;
    assertEquals("PV", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC ADMINISTRATIVO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PW;
    assertEquals("PW", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.PX;
    assertEquals("PX", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RA;
    assertEquals("RA", serviceType.getInitials());
    assertEquals("REGISTRADO PRIORITÁRIO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RB;
    assertEquals("RB", serviceType.getInitials());
    assertEquals("CARTA REGISTRADA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RC;
    assertEquals("RC", serviceType.getInitials());
    assertEquals("CARTA REGISTRADA COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RD;
    assertEquals("RD", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA DETRAN", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RE;
    assertEquals("RE", serviceType.getInitials());
    assertEquals("MALA DIRETA POSTAL ESPECIAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RF;
    assertEquals("RF", serviceType.getInitials());
    assertEquals("OBJETO DA RECEITA FEDERAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RG;
    assertEquals("RG", serviceType.getInitials());
    assertEquals("REGISTRADO DO SISTEMA SARA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RH;
    assertEquals("RH", serviceType.getInitials());
    assertEquals("REGISTRADO COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RI;
    assertEquals("RI", serviceType.getInitials());
    assertEquals("REGISTRADO PRIORITÁRIO INTERNACIONAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RJ;
    assertEquals("RJ", serviceType.getInitials());
    assertEquals("REGISTRADO AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RK;
    assertEquals("RK", serviceType.getInitials());
    assertEquals("REGISTRADO AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RL;
    assertEquals("RL", serviceType.getInitials());
    assertEquals("REGISTRADO LÓGICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RM;
    assertEquals("RM", serviceType.getInitials());
    assertEquals("REGISTRADO AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RN;
    assertEquals("RN", serviceType.getInitials());
    assertEquals("REGISTRADO AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RO;
    assertEquals("RO", serviceType.getInitials());
    assertEquals("REGISTRADO AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RP;
    assertEquals("RP", serviceType.getInitials());
    assertEquals("REEMBOLSO POSTAL - CLIENTE INSCRITO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RQ;
    assertEquals("RQ", serviceType.getInitials());
    assertEquals("REGISTRADO AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RR;
    assertEquals("RR", serviceType.getInitials());
    assertEquals("REGISTRADO INTERNACIONAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RS;
    assertEquals("RS", serviceType.getInitials());
    assertEquals("REM ECON ORG TRANSITO COM OU SEM AR", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RT;
    assertEquals("RT", serviceType.getInitials());
    assertEquals("REM ECON TALAO/CARTAO SEM AR DIGITA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RU;
    assertEquals("RU", serviceType.getInitials());
    assertEquals("REGISTRADO SERVIÇO ECT", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RV;
    assertEquals("RV", serviceType.getInitials());
    assertEquals("REM ECON CRLV/CRV/CNH COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RW;
    assertEquals("RW", serviceType.getInitials());
    assertEquals("REGISTRADO INTERNACIONAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RX;
    assertEquals("RX", serviceType.getInitials());
    assertEquals("REGISTRADO INTERNACIONAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RY;
    assertEquals("RY", serviceType.getInitials());
    assertEquals("REM ECON TALAO/CARTAO COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.RZ;
    assertEquals("RZ", serviceType.getInitials());
    assertEquals("REGISTRADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SA;
    assertEquals("SA", serviceType.getInitials());
    assertEquals("ETIQUETA SEDEX AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SB;
    assertEquals("SB", serviceType.getInitials());
    assertEquals("SEDEX 10", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SC;
    assertEquals("SC", serviceType.getInitials());
    assertEquals("SEDEX A COBRAR", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SD;
    assertEquals("SD", serviceType.getInitials());
    assertEquals("REMESSA EXPRESSA DETRAN", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SE;
    assertEquals("SE", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SF;
    assertEquals("SF", serviceType.getInitials());
    assertEquals("SEDEX AGENCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SG;
    assertEquals("SG", serviceType.getInitials());
    assertEquals("SEDEX DO SISTEMA SARA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SH;
    assertEquals("SH", serviceType.getInitials());
    assertEquals("SEDEX COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SI;
    assertEquals("SI", serviceType.getInitials());
    assertEquals("SEDEX AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SJ;
    assertEquals("SJ", serviceType.getInitials());
    assertEquals("SEDEX HOJE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SK;
    assertEquals("SK", serviceType.getInitials());
    assertEquals("SEDEX AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SL;
    assertEquals("SL", serviceType.getInitials());
    assertEquals("SEDEX LÓGICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SM;
    assertEquals("SM", serviceType.getInitials());
    assertEquals("SEDEX 12", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SN;
    assertEquals("SN", serviceType.getInitials());
    assertEquals("SEDEX AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SO;
    assertEquals("SO", serviceType.getInitials());
    assertEquals("SEDEX AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SP;
    assertEquals("SP", serviceType.getInitials());
    assertEquals("SEDEX PRÉ-FRANQUEADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SQ;
    assertEquals("SQ", serviceType.getInitials());
    assertEquals("SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SR;
    assertEquals("SR", serviceType.getInitials());
    assertEquals("SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SS;
    assertEquals("SS", serviceType.getInitials());
    assertEquals("SEDEX FÍSICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.ST;
    assertEquals("ST", serviceType.getInitials());
    assertEquals("REM EXPRES TALAO/CARTAO SEM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SU;
    assertEquals("SU", serviceType.getInitials());
    assertEquals("ENCOMENDA SERVIÇO EXPRESSA ECT", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SV;
    assertEquals("SV", serviceType.getInitials());
    assertEquals("REM EXPRES CRLV/CRV/CNH COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SW;
    assertEquals("SW", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SX;
    assertEquals("SX", serviceType.getInitials());
    assertEquals("SEDEX 10", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SY;
    assertEquals("SY", serviceType.getInitials());
    assertEquals("REM EXPRES TALAO/CARTAO COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.SZ;
    assertEquals("SZ", serviceType.getInitials());
    assertEquals("SEDEX AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.TC;
    assertEquals("TC", serviceType.getInitials());
    assertEquals("TESTE (OBJETO PARA TREINAMENTO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.TE;
    assertEquals("TE", serviceType.getInitials());
    assertEquals("TESTE (OBJETO PARA TREINAMENTO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.TR;
    assertEquals("TR", serviceType.getInitials());
    assertEquals("OBJETO TREINAMENTO - NÃO GERA PRÉ-ALERTA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.TS;
    assertEquals("TS", serviceType.getInitials());
    assertEquals("TESTE (OBJETO PARA TREINAMENTO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.VA;
    assertEquals("VA", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.VC;
    assertEquals("VC", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.VD;
    assertEquals("VD", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.VE;
    assertEquals("VE", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.VF;
    assertEquals("VF", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.VV;
    assertEquals("VV", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.XA;
    assertEquals("XA", serviceType.getInitials());
    assertEquals("AVISO CHEGADA OBJETO INT TRIBUTADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.XM;
    assertEquals("XM", serviceType.getInitials());
    assertEquals("SEDEX MUNDI", serviceType.getDescription());

    serviceType = TrackObjectServiceType.XR;
    assertEquals("XR", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL (PPS TRIBUTADO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.XX;
    assertEquals("XX", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL (PPS TRIBUTADO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.UNKNOWN;
    assertEquals("", serviceType.getInitials());
    assertEquals("", serviceType.getDescription());
  }

  @Test
  public void testValueOf() {
    TrackObjectServiceType serviceType;

    serviceType = TrackObjectServiceType.valueOf("AA");
    assertEquals("AA", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("AB");
    assertEquals("AB", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("AL");
    assertEquals("AL", serviceType.getInitials());
    assertEquals("AGENTES DE LEITURA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("AR");
    assertEquals("AR", serviceType.getInitials());
    assertEquals("AVISO DE RECEBIMENTO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("AS");
    assertEquals("AS", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC - ACAO SOCIAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("BE");
    assertEquals("BE", serviceType.getInitials());
    assertEquals("REMESSA ECONÔMICA S/ AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("BF");
    assertEquals("BF", serviceType.getInitials());
    assertEquals("REMESSA EXPRESSA S/ AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("BG");
    assertEquals("BG", serviceType.getInitials());
    assertEquals("ETIQUETA LOG REM ECON C/AR BG", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("BH");
    assertEquals("BH", serviceType.getInitials());
    assertEquals("MENSAGEM FÍSICO-DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("BI");
    assertEquals("BI", serviceType.getInitials());
    assertEquals("ETIQUETA LÓG REGIST URG", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CA");
    assertEquals("CA", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CB");
    assertEquals("CB", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CC");
    assertEquals("CC", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CD");
    assertEquals("CD", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CE");
    assertEquals("CE", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CF");
    assertEquals("CF", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CG");
    assertEquals("CG", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CH");
    assertEquals("CH", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CI");
    assertEquals("CI", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CJ");
    assertEquals("CJ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CK");
    assertEquals("CK", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CL");
    assertEquals("CL", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CM");
    assertEquals("CM", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CN");
    assertEquals("CN", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CO");
    assertEquals("CO", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CP");
    assertEquals("CP", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CQ");
    assertEquals("CQ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CR");
    assertEquals("CR", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CS");
    assertEquals("CS", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CT");
    assertEquals("CT", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CU");
    assertEquals("CU", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CV");
    assertEquals("CV", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CW");
    assertEquals("CW", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CX");
    assertEquals("CX", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CY");
    assertEquals("CY", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("CZ");
    assertEquals("CZ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COLIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DA");
    assertEquals("DA", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX C/ AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DB");
    assertEquals("DB", serviceType.getInitials());
    assertEquals("REMESSA EXPRESSA C/ AR DIGITAL-BRADESCO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DC");
    assertEquals("DC", serviceType.getInitials());
    assertEquals("REMESSA EXPRESSA (ORGAO TRANSITO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DD");
    assertEquals("DD", serviceType.getInitials());
    assertEquals("DEVOLUÇÃO DE DOCUMENTOS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DE");
    assertEquals("DE", serviceType.getInitials());
    assertEquals("REMESSA EXPRESSA C/ AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DF");
    assertEquals("DF", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DG");
    assertEquals("DG", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DI");
    assertEquals("DI", serviceType.getInitials());
    assertEquals("REM EXPRES COM AR DIGITAL ITAU", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DJ");
    assertEquals("DJ", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DK");
    assertEquals("DK", serviceType.getInitials());
    assertEquals("SEDEX EXTRA GRANDE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DL");
    assertEquals("DL", serviceType.getInitials());
    assertEquals("SEDEX LÓGICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DM");
    assertEquals("DM", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DN");
    assertEquals("DN", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DO");
    assertEquals("DO", serviceType.getInitials());
    assertEquals("REM EXPRES COM AR DIGITAL ITAU UNIBANCO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DP");
    assertEquals("DP", serviceType.getInitials());
    assertEquals("SEDEX PAGAMENTO ENTREGA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DQ");
    assertEquals("DQ", serviceType.getInitials());
    assertEquals("REM EXPRES COM AR DIGITAL BRADESCO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DR");
    assertEquals("DR", serviceType.getInitials());
    assertEquals("REM EXPRES COM AR DIGITAL SANTANDER", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DS");
    assertEquals("DS", serviceType.getInitials());
    assertEquals("REM EXPRES COM AR DIGITAL SANTANDER", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DT");
    assertEquals("DT", serviceType.getInitials());
    assertEquals("REMESSA ECON.SEG.TRANSITO C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DU");
    assertEquals("DU", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DV");
    assertEquals("DV", serviceType.getInitials());
    assertEquals("SEDEX COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DW");
    assertEquals("DW", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LÓGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DX");
    assertEquals("DX", serviceType.getInitials());
    assertEquals("SEDEX 10 LÓGICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DY");
    assertEquals("DY", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ FÍSICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("DZ");
    assertEquals("DZ", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EA");
    assertEquals("EA", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EB");
    assertEquals("EB", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EC");
    assertEquals("EC", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("ED");
    assertEquals("ED", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PACKET EXPRESS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EE");
    assertEquals("EE", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EF");
    assertEquals("EF", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EG");
    assertEquals("EG", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EH");
    assertEquals("EH", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EI");
    assertEquals("EI", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EJ");
    assertEquals("EJ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EK");
    assertEquals("EK", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EL");
    assertEquals("EL", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EM");
    assertEquals("EM", serviceType.getInitials());
    assertEquals("SEDEX MUNDI", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EN");
    assertEquals("EN", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EO");
    assertEquals("EO", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EP");
    assertEquals("EP", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EQ");
    assertEquals("EQ", serviceType.getInitials());
    assertEquals("ENCOMENDA SERVIÇO NÃO EXPRESSA ECT", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("ER");
    assertEquals("ER", serviceType.getInitials());
    assertEquals("REGISTRADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("ES");
    assertEquals("ES", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("ET");
    assertEquals("ET", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EU");
    assertEquals("EU", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EV");
    assertEquals("EV", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EW");
    assertEquals("EW", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EX");
    assertEquals("EX", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EY");
    assertEquals("EY", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("EZ");
    assertEquals("EZ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL EMS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("FA");
    assertEquals("FA", serviceType.getInitials());
    assertEquals("FAC REGISTRADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("FB");
    assertEquals("FB", serviceType.getInitials());
    assertEquals("FAC REGISTRADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("FC");
    assertEquals("FC", serviceType.getInitials());
    assertEquals("FAC REGISTRADO (5 DIAS)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("FD");
    assertEquals("FD", serviceType.getInitials());
    assertEquals("FAC REGISTRADO (10 DIAS)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("FE");
    assertEquals("FE", serviceType.getInitials());
    assertEquals("ENCOMENDA FNDE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("FF");
    assertEquals("FF", serviceType.getInitials());
    assertEquals("REGISTRADO DETRAN", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("FH");
    assertEquals("FH", serviceType.getInitials());
    assertEquals("FAC REGISTRADO C/ AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("FJ");
    assertEquals("FJ", serviceType.getInitials());
    assertEquals("REMESSA ECONÔMICA C/ AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("FM");
    assertEquals("FM", serviceType.getInitials());
    assertEquals("FAC REGISTRADO (MONITORADO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("FR");
    assertEquals("FR", serviceType.getInitials());
    assertEquals("FAC REGISTRADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("IA");
    assertEquals("IA", serviceType.getInitials());
    assertEquals("INTEGRADA AVULSA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("IC");
    assertEquals("IC", serviceType.getInitials());
    assertEquals("INTEGRADA A COBRAR", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("ID");
    assertEquals("ID", serviceType.getInitials());
    assertEquals("INTEGRADA DEVOLUCAO DE DOCUMENTO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("IE");
    assertEquals("IE", serviceType.getInitials());
    assertEquals("INTEGRADA ESPECIAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("IF");
    assertEquals("IF", serviceType.getInitials());
    assertEquals("CPF", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("II");
    assertEquals("II", serviceType.getInitials());
    assertEquals("INTEGRADA INTERNO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("IK");
    assertEquals("IK", serviceType.getInitials());
    assertEquals("INTEGRADA COM COLETA SIMULTANEA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("IM");
    assertEquals("IM", serviceType.getInitials());
    assertEquals("INTEGRADA MEDICAMENTOS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("IN");
    assertEquals("IN", serviceType.getInitials());
    assertEquals("OBJ DE CORRESP E EMS REC EXTERIOR", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("IP");
    assertEquals("IP", serviceType.getInitials());
    assertEquals("INTEGRADA PROGRAMADA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("IR");
    assertEquals("IR", serviceType.getInitials());
    assertEquals("IMPRESSO REGISTRADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("IS");
    assertEquals("IS", serviceType.getInitials());
    assertEquals("INTEGRADA STANDARD", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("IT");
    assertEquals("IT", serviceType.getInitials());
    assertEquals("INTEGRADA TERMOLÁBIL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("IU");
    assertEquals("IU", serviceType.getInitials());
    assertEquals("INTEGRADA URGENTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("IX");
    assertEquals("IX", serviceType.getInitials());
    assertEquals("EDEI ENCOMENDA EXPRESSA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JA");
    assertEquals("JA", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JB");
    assertEquals("JB", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JC");
    assertEquals("JC", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JD");
    assertEquals("JD", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA S/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JE");
    assertEquals("JE", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JF");
    assertEquals("JF", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JG");
    assertEquals("JG", serviceType.getInitials());
    assertEquals("REGISTRADO PRIORITÁRIO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JH");
    assertEquals("JH", serviceType.getInitials());
    assertEquals("REGISTRADO PRIORITÁRIO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JI");
    assertEquals("JI", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA S/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JJ");
    assertEquals("JJ", serviceType.getInitials());
    assertEquals("REGISTRADO JUSTIÇA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JK");
    assertEquals("JK", serviceType.getInitials());
    assertEquals("REMESSA ECONÔMICA S/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JL");
    assertEquals("JL", serviceType.getInitials());
    assertEquals("REGISTRADO LÓGICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JM");
    assertEquals("JM", serviceType.getInitials());
    assertEquals("MALA DIRETA POSTAL ESPECIAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JN");
    assertEquals("JN", serviceType.getInitials());
    assertEquals("MALA DIRETA POSTAL ESPECIAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JO");
    assertEquals("JO", serviceType.getInitials());
    assertEquals("REGISTRADO PRIORITÁRIO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JP");
    assertEquals("JP", serviceType.getInitials());
    assertEquals("OBJETO RECEITA FEDERAL (EXCLUSIVO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JQ");
    assertEquals("JQ", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JR");
    assertEquals("JR", serviceType.getInitials());
    assertEquals("REGISTRADO PRIORITÁRIO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JS");
    assertEquals("JS", serviceType.getInitials());
    assertEquals("REGISTRADO LÓGICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JT");
    assertEquals("JT", serviceType.getInitials());
    assertEquals("REGISTRADO URGENTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JU");
    assertEquals("JU", serviceType.getInitials());
    assertEquals("ETIQUETA FÍS REGIST URG", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JV");
    assertEquals("JV", serviceType.getInitials());
    assertEquals("REMESSA ECONÔMICA C/AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JW");
    assertEquals("JW", serviceType.getInitials());
    assertEquals("CARTA COMERCIAL A FATURAR (5 DIAS)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JX");
    assertEquals("JX", serviceType.getInitials());
    assertEquals("CARTA COMERCIAL A FATURAR (10 DIAS)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JY");
    assertEquals("JY", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA (5 DIAS)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("JZ");
    assertEquals("JZ", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA (10 DIAS)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LA");
    assertEquals("LA", serviceType.getInitials());
    assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LB");
    assertEquals("LB", serviceType.getInitials());
    assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LC");
    assertEquals("LC", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LD");
    assertEquals("LD", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LE");
    assertEquals("LE", serviceType.getInitials());
    assertEquals("LOGÍSTICA REVERSA ECONOMICA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LF");
    assertEquals("LF", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LG");
    assertEquals("LG", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LH");
    assertEquals("LH", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LI");
    assertEquals("LI", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LJ");
    assertEquals("LJ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LK");
    assertEquals("LK", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LL");
    assertEquals("LL", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LM");
    assertEquals("LM", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LN");
    assertEquals("LN", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LP");
    assertEquals("LP", serviceType.getInitials());
    assertEquals("LOGÍSTICA REVERSA SIMULTÂNEA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LQ");
    assertEquals("LQ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LS");
    assertEquals("LS", serviceType.getInitials());
    assertEquals("LOGISTICA REVERSA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LV");
    assertEquals("LV", serviceType.getInitials());
    assertEquals("LOGISTICA REVERSA EXPRESSA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LW");
    assertEquals("LW", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LX");
    assertEquals("LX", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PACKET ECONOMIC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LY");
    assertEquals("LY", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("LZ");
    assertEquals("LZ", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL PRIME", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("MA");
    assertEquals("MA", serviceType.getInitials());
    assertEquals("TELEGRAMA - SERVICOS ADICIONAIS", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("MB");
    assertEquals("MB", serviceType.getInitials());
    assertEquals("TELEGRAMA DE BALCAO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("MC");
    assertEquals("MC", serviceType.getInitials());
    assertEquals("TELEGRAMA FONADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("MD");
    assertEquals("MD", serviceType.getInitials());
    assertEquals("MAQUINA DE FRANQUEAR (LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("ME");
    assertEquals("ME", serviceType.getInitials());
    assertEquals("TELEGRAMA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("MF");
    assertEquals("MF", serviceType.getInitials());
    assertEquals("TELEGRAMA FONADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("MH");
    assertEquals("MH", serviceType.getInitials());
    assertEquals("CARTA VIA INTERNET", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("MK");
    assertEquals("MK", serviceType.getInitials());
    assertEquals("TELEGRAMA CORPORATIVO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("MM");
    assertEquals("MM", serviceType.getInitials());
    assertEquals("TELEGRAMA GRANDES CLIENTES", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("MP");
    assertEquals("MP", serviceType.getInitials());
    assertEquals("TELEGRAMA PRÉ-PAGO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("MS");
    assertEquals("MS", serviceType.getInitials());
    assertEquals("ENCOMENDA SAUDE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("MT");
    assertEquals("MT", serviceType.getInitials());
    assertEquals("TELEGRAMA VIA TELEMAIL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("MY");
    assertEquals("MY", serviceType.getInitials());
    assertEquals("TELEGRAMA INTERNACIONAL ENTRANTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("MZ");
    assertEquals("MZ", serviceType.getInitials());
    assertEquals("TELEGRAMA VIA CORREIOS ON LINE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("NE");
    assertEquals("NE", serviceType.getInitials());
    assertEquals("TELE SENA RESGATADA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("NX");
    assertEquals("NX", serviceType.getInitials());
    assertEquals("EDEI ENCOMENDA NAO URGENTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("OA");
    assertEquals("OA", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("OB");
    assertEquals("OB", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("OC");
    assertEquals("OC", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("OD");
    assertEquals("OD", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX (ETIQ FÍSICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("OF");
    assertEquals("OF", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("OG");
    assertEquals("OG", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("OH");
    assertEquals("OH", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("OI");
    assertEquals("OI", serviceType.getInitials());
    assertEquals("ETIQUETA LOGICA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PA");
    assertEquals("PA", serviceType.getInitials());
    assertEquals("PASSAPORTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PB");
    assertEquals("PB", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC - NÃO URGENTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PC");
    assertEquals("PC", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC A COBRAR", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PD");
    assertEquals("PD", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PE");
    assertEquals("PE", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC (ETIQUETA FISICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PF");
    assertEquals("PF", serviceType.getInitials());
    assertEquals("PASSAPORTE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PG");
    assertEquals("PG", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC (ETIQUETA FISICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PH");
    assertEquals("PH", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC (ETIQUETA LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PI");
    assertEquals("PI", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PJ");
    assertEquals("PJ", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PK");
    assertEquals("PK", serviceType.getInitials());
    assertEquals("PAC EXTRA GRANDE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PL");
    assertEquals("PL", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PM");
    assertEquals("PM", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC (ETIQ FÍSICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PN");
    assertEquals("PN", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PO");
    assertEquals("PO", serviceType.getInitials());
    assertEquals("ENCOMENDA PAC (ETIQ LOGICA)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PP");
    assertEquals("PP", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PQ");
    assertEquals("PQ", serviceType.getInitials());
    assertEquals("ETIQUETA LOGICA PAC MINI", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PR");
    assertEquals("PR", serviceType.getInitials());
    assertEquals("REEMBOLSO POSTAL - CLIENTE AVULSO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PS");
    assertEquals("PS", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PT");
    assertEquals("PT", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PU");
    assertEquals("PU", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PV");
    assertEquals("PV", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC ADMINISTRATIVO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PW");
    assertEquals("PW", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("PX");
    assertEquals("PX", serviceType.getInitials());
    assertEquals("ETIQUETA LÓGICA PAC", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RA");
    assertEquals("RA", serviceType.getInitials());
    assertEquals("REGISTRADO PRIORITÁRIO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RB");
    assertEquals("RB", serviceType.getInitials());
    assertEquals("CARTA REGISTRADA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RC");
    assertEquals("RC", serviceType.getInitials());
    assertEquals("CARTA REGISTRADA COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RD");
    assertEquals("RD", serviceType.getInitials());
    assertEquals("REMESSA ECONOMICA DETRAN", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RE");
    assertEquals("RE", serviceType.getInitials());
    assertEquals("MALA DIRETA POSTAL ESPECIAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RF");
    assertEquals("RF", serviceType.getInitials());
    assertEquals("OBJETO DA RECEITA FEDERAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RG");
    assertEquals("RG", serviceType.getInitials());
    assertEquals("REGISTRADO DO SISTEMA SARA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RH");
    assertEquals("RH", serviceType.getInitials());
    assertEquals("REGISTRADO COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RI");
    assertEquals("RI", serviceType.getInitials());
    assertEquals("REGISTRADO PRIORITÁRIO INTERNACIONAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RJ");
    assertEquals("RJ", serviceType.getInitials());
    assertEquals("REGISTRADO AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RK");
    assertEquals("RK", serviceType.getInitials());
    assertEquals("REGISTRADO AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RL");
    assertEquals("RL", serviceType.getInitials());
    assertEquals("REGISTRADO LÓGICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RM");
    assertEquals("RM", serviceType.getInitials());
    assertEquals("REGISTRADO AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RN");
    assertEquals("RN", serviceType.getInitials());
    assertEquals("REGISTRADO AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RO");
    assertEquals("RO", serviceType.getInitials());
    assertEquals("REGISTRADO AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RP");
    assertEquals("RP", serviceType.getInitials());
    assertEquals("REEMBOLSO POSTAL - CLIENTE INSCRITO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RQ");
    assertEquals("RQ", serviceType.getInitials());
    assertEquals("REGISTRADO AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RR");
    assertEquals("RR", serviceType.getInitials());
    assertEquals("REGISTRADO INTERNACIONAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RS");
    assertEquals("RS", serviceType.getInitials());
    assertEquals("REM ECON ORG TRANSITO COM OU SEM AR", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RT");
    assertEquals("RT", serviceType.getInitials());
    assertEquals("REM ECON TALAO/CARTAO SEM AR DIGITA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RU");
    assertEquals("RU", serviceType.getInitials());
    assertEquals("REGISTRADO SERVIÇO ECT", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RV");
    assertEquals("RV", serviceType.getInitials());
    assertEquals("REM ECON CRLV/CRV/CNH COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RW");
    assertEquals("RW", serviceType.getInitials());
    assertEquals("REGISTRADO INTERNACIONAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RX");
    assertEquals("RX", serviceType.getInitials());
    assertEquals("REGISTRADO INTERNACIONAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RY");
    assertEquals("RY", serviceType.getInitials());
    assertEquals("REM ECON TALAO/CARTAO COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("RZ");
    assertEquals("RZ", serviceType.getInitials());
    assertEquals("REGISTRADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SA");
    assertEquals("SA", serviceType.getInitials());
    assertEquals("ETIQUETA SEDEX AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SB");
    assertEquals("SB", serviceType.getInitials());
    assertEquals("SEDEX 10", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SC");
    assertEquals("SC", serviceType.getInitials());
    assertEquals("SEDEX A COBRAR", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SD");
    assertEquals("SD", serviceType.getInitials());
    assertEquals("REMESSA EXPRESSA DETRAN", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SE");
    assertEquals("SE", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SF");
    assertEquals("SF", serviceType.getInitials());
    assertEquals("SEDEX AGENCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SG");
    assertEquals("SG", serviceType.getInitials());
    assertEquals("SEDEX DO SISTEMA SARA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SH");
    assertEquals("SH", serviceType.getInitials());
    assertEquals("SEDEX COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SI");
    assertEquals("SI", serviceType.getInitials());
    assertEquals("SEDEX AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SJ");
    assertEquals("SJ", serviceType.getInitials());
    assertEquals("SEDEX HOJE", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SK");
    assertEquals("SK", serviceType.getInitials());
    assertEquals("SEDEX AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SL");
    assertEquals("SL", serviceType.getInitials());
    assertEquals("SEDEX LÓGICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SM");
    assertEquals("SM", serviceType.getInitials());
    assertEquals("SEDEX 12", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SN");
    assertEquals("SN", serviceType.getInitials());
    assertEquals("SEDEX AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SO");
    assertEquals("SO", serviceType.getInitials());
    assertEquals("SEDEX AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SP");
    assertEquals("SP", serviceType.getInitials());
    assertEquals("SEDEX PRÉ-FRANQUEADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SQ");
    assertEquals("SQ", serviceType.getInitials());
    assertEquals("SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SR");
    assertEquals("SR", serviceType.getInitials());
    assertEquals("SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SS");
    assertEquals("SS", serviceType.getInitials());
    assertEquals("SEDEX FÍSICO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("ST");
    assertEquals("ST", serviceType.getInitials());
    assertEquals("REM EXPRES TALAO/CARTAO SEM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SU");
    assertEquals("SU", serviceType.getInitials());
    assertEquals("ENCOMENDA SERVIÇO EXPRESSA ECT", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SV");
    assertEquals("SV", serviceType.getInitials());
    assertEquals("REM EXPRES CRLV/CRV/CNH COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SW");
    assertEquals("SW", serviceType.getInitials());
    assertEquals("ENCOMENDA SEDEX", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SX");
    assertEquals("SX", serviceType.getInitials());
    assertEquals("SEDEX 10", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SY");
    assertEquals("SY", serviceType.getInitials());
    assertEquals("REM EXPRES TALAO/CARTAO COM AR DIGITAL", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("SZ");
    assertEquals("SZ", serviceType.getInitials());
    assertEquals("SEDEX AGÊNCIA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("TC");
    assertEquals("TC", serviceType.getInitials());
    assertEquals("TESTE (OBJETO PARA TREINAMENTO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("TE");
    assertEquals("TE", serviceType.getInitials());
    assertEquals("TESTE (OBJETO PARA TREINAMENTO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("TR");
    assertEquals("TR", serviceType.getInitials());
    assertEquals("OBJETO TREINAMENTO - NÃO GERA PRÉ-ALERTA", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("TS");
    assertEquals("TS", serviceType.getInitials());
    assertEquals("TESTE (OBJETO PARA TREINAMENTO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("VA");
    assertEquals("VA", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("VC");
    assertEquals("VC", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("VD");
    assertEquals("VD", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("VE");
    assertEquals("VE", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("VF");
    assertEquals("VF", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("VV");
    assertEquals("VV", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL COM VALOR DECLARADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("XA");
    assertEquals("XA", serviceType.getInitials());
    assertEquals("AVISO CHEGADA OBJETO INT TRIBUTADO", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("XM");
    assertEquals("XM", serviceType.getInitials());
    assertEquals("SEDEX MUNDI", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("XR");
    assertEquals("XR", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL (PPS TRIBUTADO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.valueOf("XX");
    assertEquals("XX", serviceType.getInitials());
    assertEquals("OBJETO INTERNACIONAL (PPS TRIBUTADO)", serviceType.getDescription());

    serviceType = TrackObjectServiceType.UNKNOWN;

    try {
      serviceType = TrackObjectServiceType.valueOf(null);

      fail("Should have throw exception");
    } catch (NullPointerException e) {
      // ignore
    }

    assertEquals("", serviceType.getInitials());
    assertEquals("", serviceType.getDescription());

    serviceType = TrackObjectServiceType.UNKNOWN;

    try {
      serviceType = TrackObjectServiceType.valueOf("invalid");

      fail("Should have throw exception");
    } catch (IllegalArgumentException e) {
      // ignore
    }

    assertEquals("", serviceType.getInitials());
    assertEquals("", serviceType.getDescription());
  }
}
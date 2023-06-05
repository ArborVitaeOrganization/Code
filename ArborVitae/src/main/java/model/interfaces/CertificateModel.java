package model.interfaces;

import java.sql.Date;
import java.util.ArrayList;

import model.bean.Certificate;

public interface CertificateModel {

	public ArrayList<Certificate> doRetrieveByDate(Date date);
	public Certificate doRetrieveByKey(int codeCertificate);
	public boolean doAdd(Certificate c);
	public boolean doRemove(int codeCertificate);
}

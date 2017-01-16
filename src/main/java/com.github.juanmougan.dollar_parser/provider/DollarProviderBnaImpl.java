public class DollarProviderBnaImpl implements DollarProvider {
	public ExchangeRate getBnaExchangeRate() {
		// Maybe move this parse into an inner layer (say, a BnaCurrencyParser that implements CurrencyParser),
    //   in order to reuse the jsoup part (and only use this URL as a param: doc.select("Dolar U.S.A");)
    Document doc = Jsoup.connect("http://www.bna.com.ar/").get();
		Elements cotizacionBna = doc.select("Dolar U.S.A");
		// TODO get the next element in the table
	}
}

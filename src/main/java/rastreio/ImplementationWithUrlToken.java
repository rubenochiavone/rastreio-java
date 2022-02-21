package rastreio;

/**
 * Rastreio implementation that needs an URL with token.
 */
public abstract class ImplementationWithUrlToken extends Implementation {
  protected String mUrlToken;

  /**
   * Set URL with token.
   * 
   * @param urlToken string representing the private URL and token to be used
   */
  public void setUrlToken(String urlToken) {
    this.mUrlToken = urlToken;
  }
}

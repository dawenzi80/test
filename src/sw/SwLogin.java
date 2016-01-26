/**
 * 閿熸枻鎷烽敓鎹凤綇鎷�<br>
 * 閿熸枻鎷烽敓绔綇鎷稬iuxw <br>
 * 閿熻姤鏈敓鏂ゆ嫹1.0<br>
 * 閿熺潾璁规嫹閿熸枻鎷�<br>
 * 2013-7-1 閿熸枻鎷烽敓鏂ゆ嫹閿熶茎纭锋嫹<br>
 * 閿熸枻鎷锋敞閿熸枻鎷�<br>
 */
package sw;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlCheckBoxInput;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

/**
 * 閿熸枻鎷烽敓鏂ゆ嫹<br>
 * 
 * @author KGZT<br>
 * @version SwLogin.java 2013-7-1 閿熸枻鎷烽敓鏂ゆ嫹02:28:17<br>
 * <br>
 */
public class SwLogin
{

	/**
	 * 
	 */
	public SwLogin()
	{
		// TODO Auto-generated constructor stub
	}

	public void login()
	{
		try
		{
			final WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
			
			WebClientOptions option = webClient.getOptions();
			option.setJavaScriptEnabled(true);
			option.setCssEnabled(true);
			option.setActiveXNative(true);
			option.setRedirectEnabled(true);
			option.setUseInsecureSSL(true);
			webClient.setAjaxController(new NicelyResynchronizingAjaxController());
			option.setTimeout(2000);
			option.setThrowExceptionOnScriptError(false);
			webClient.setJavaScriptTimeout(5000);
			
			
			
			webClient.waitForBackgroundJavaScript(2000);
			HtmlPage page = (HtmlPage) webClient.getPage("http://192.168.3.10");
			//HtmlPage page = (HtmlPage) webClient.getPage("http://192.168.2.158/view/login.html");
			HtmlTextInput checkcode = (HtmlTextInput) page.getElementById("checkCode");
			HtmlTextInput verifycode = (HtmlTextInput) page.getElementById("verifycode");
			System.out.println("text:" + checkcode.getText());
			System.out.println("value:" + checkcode.getValueAttribute());
			System.out.println("value:" + checkcode.getTextContent());

			HtmlTextInput username = (HtmlTextInput) page.getElementById("user");
			HtmlPasswordInput password = (HtmlPasswordInput) page.getElementById("pwd");
			username.setValueAttribute("admin");
			password.setValueAttribute("admin");
			verifycode.setValueAttribute(checkcode.getText());

			System.out.println("username Text:" + username.getText() + ",TextContent:" + username.getTextContent() + ",value:" + username.getValueAttribute());
			System.out.println("password Text:" + password.getText() + ",TextContent:" + password.getTextContent() + ",value:" + password.getValueAttribute());
			System.out.println("verifycode Text:" + verifycode.getText() + ",TextContent:" + verifycode.getTextContent() + ",value:" + verifycode.getValueAttribute());

			DomNodeList<DomElement> buttons = page.getElementsByTagName("input");
			System.out.println("size:" + buttons.size());
			for (DomElement de : buttons)
			{
				//HtmlButton button = (HtmlButton) de;
				//System.out.println("button:"+de.getNodeName()+","+de.getNodeType()+","+de.getNodeValue()+","+de.getLocalName()+","+de.getQualifiedName()+","+de.getTextContent());
				if (("" + de).indexOf("value=\"Login\" class=\"log_button\"") != -1)
				{
					System.out.println("button:" + de);
					HtmlButtonInput button = (HtmlButtonInput) de;
					String gettext="HTTP.getText = function(url,value,callback,param)"+//
					"{"+//
					"var randText = HTTP.myRandom();"+//
					"randText = randText + parseInt(Math.random()*10);"+//
					"if(url.indexOf(\"?\") > -1)"+//
					"{"+//
					"url += \"&rand=\" + randText;"+//
					"}"+//
					"else"+//
					"{"+//
					"url += \"?rand=\" + randText;"+//
					"}"+//
					"var request = HTTP.newRequest();"+//
					"try"+//
					"{"+//
					"request.open(\"POST\", url, true);"+//
					"request.setRequestHeader(\"Method\", \"POST \"+url+\" HTTP/1.1\");"+//
					"request.setRequestHeader(\"Content-Type\", \"text/html\");"+//
					"request.onreadystatechange = function()"+//
					"{alert('------------readyState:'+request.readyState+',request.status:'+request.status);"+//
					"alert('------------responseText:'+request.responseXml);"+//
					"if(request.readyState == 4)"+//
					"{"+//
					"if(request.status == 200 || request.status == 408)"+//
					"{"+//
					"if(request.status == 408)"+//
					"{"+//
					"alert(LM.LD[\"Tag1069\"]);"+//
					"var localHere = window.top.location.href;"+//
					"if(localHere.indexOf(\"/login.html\") == -1)"+//
					"{"+//
					"if(param == 1)"+//
					"{"+//
					"return callback(new Object());"+//
					"}"+//
					"else"+//
					"{"+//
					"if(callback)"+//
					"{"+//
					"return callback(\"\");"+//
					"}"+//
					"}"+//
					"}"+//
					"}"+//
					"else"+//
					"{"+//
					"if(param == 4)"+//
					"{"+//
					"return callback(request.responseText);"+//
					"}"+//
					"if(request.responseText.indexOf(\"ErrorMsg=1016\") > -1)"+//
					"{"+//
					"request.abort();"+//
					"request = null;"+//
					"if(HTTP.isChild && location.href.indexOf(\"login.html\")<0)"+//
					"{"+//
					"window.returnValue = \"login\";"+//
					"window.close();"+//
					"}"+//
					"else"+//
					"{"+//
					"HTTP.backToLogin();"+//
					"}"+//
					"return;"+//
					"}"+//
					"if(param == 1)"+//
					"{"+//
					"return callback(HTTP.unpackageMsg(request.responseText));"+//
					"}"+//
					"else if(param == 0)"+//
					"{"+//
					"var tempStr = request.responseText;"+//
					"if(callback)"+//
					"{"+//
					"return callback(tempStr.substr(tempStr.indexOf(\"</rpc-reply>\")+ 12,tempStr.length));"+//
					"}"+//
					"}"+//
					"else "+//
					"{"+//
					"return callback(request.responseText);"+//
					"}"+//
					"}"+//
					"}"+//
					"else"+//
					"{"+//
					"if (HTTP.restartFlag)"+//
					"{"+//
					"HTTP.restartFlag = false;"+//
					"return;"+//
					"}"+//
					"if(request.status == 0)"+//
					"{"+//
					"return;"+//
					"}"+//
					"alert(LM.LD[\"Tag1069\"]);"+//
					"var localHere = window.top.location.href;"+//
					"if(localHere.indexOf(\"/login.html\") == -1)"+//
					"{"+//
					"if(param == 1)"+//
					"{"+//
					"return callback(new Object());"+//
					"}"+//
					"else"+//
					"{"+//
					"if(callback)"+//
					"{"+//
					"return callback(\"\");"+//
					"}"+//
					"}"+//
					"}"+//
					"return;"+//
					"}"+//
					"}"+//
					"};"+//
					"request.send(value);"+//
					"}"+//
					"catch(e)"+//
					"{}"+//
					"};";
					System.out.println("gettext:"+gettext);
					String queryTableAll = "HTTP.queryTableAll = function(value,callback,sessionClient)" + //
							"{" + //
							"var session = sessionClient ? sessionClient : HTTP.getSession();" + //
							
							"HTTP.isChild = sessionClient ? true : false;" + //
							"if(location.href.indexOf(\"/main.html\")>-1)" + //
							"{" + //
							"HTTP.isChild = false;" + //
							"}" + //
							"HTTP.isSessoinOk(session);" + //
							"var url = HTTP.configUrl + session;" + //
							//"alert('url:'+url);"+//
							//"alert('HTTP.isChild:'+HTTP.isChild);"+//
							//"alert('value:'+value);"+//
							//"alert('callback:'+callback);"+//
							"HTTP.getText(url,value,callback,1);" + //
							"};";// 
					String getvalue = "HTTP.isSessoinOk = function(session){alert('session is :'+session);};" + //
							"function getValue(result){" + //
							"var ret = HTTP.packageMsg(getSoftwareRev(),1);" + //
							"var SoftwareRev='';" + //
							"HTTP.queryTableAll(ret,function(xh){alert('xh:'+xh);" + //
							"if(xh.entPhysicalEntry)" + //
							"{" + //
							" for(var i =0;i<xh.entPhysicalEntry.length;i++)" + //
							" {" + //
							"if(xh.entPhysicalEntry[i][\"entPhysicalName\"].indexOf(\"MPU Board\")==0)" + //
							"{" + //
							" SoftwareRev=xh.entPhysicalEntry[i][\"entPhysicalSoftwareRev\"];" + //
							"break;" + //
							"}" + //
							"}" + //
							"}" + //
							"alert('SoftwareRev:'+SoftwareRev);" + //
							"if(SoftwareRev>=\"Version 5.70 V100R005C00\")" + //
							"{" + //
							"cookieOperate(M('keepPwd'));" + //
							"var expiration = new Date(2099,12,31);" + //
							"var currTime =new Date().getTime();" + //
							"var cookie = currTime+\"=\" + result.split(\"=\")[1] + \";expires=\" + expiration.toGMTString();" + //
							"document.cookie = cookie;" + //
							//alert(cookie);
							"window.location.href=\"main.html?sid=\"+currTime+\"&LanguageType=\"+M('language').value;" + //
							"}" + //
							"},result);" + //
							"};";//

					//System.out.println("js:" + getvalue);

					//ScriptResult sr = page.executeJavaScript(gettext+queryTableAll+getvalue + ";var msg = HTTP.packageMsg(getLoginMsg(user.value,pwd.value,0),2);HTTP.login(msg,getValue);");

					//System.out.println("script result:"+sr.getJavaScriptResult());
					//System.out.println("page:"+sr.getNewPage());
					//page.

					button.click();
					//page.executeJavaScript(" getValue('1234567');");
					break;
					//HtmlPage page2 = (HtmlPage)webClient.getCurrentWindow().getEnclosedPage();
					//System.out.println("text:"+page2.asText());
				}
			}
			
			List<WebWindow> wws = webClient.getWebWindows();
			HtmlPage leftpage = null;
			HtmlPage rightpage = null;
			for (WebWindow ww : wws)
			{
				HtmlPage framepage = (HtmlPage)ww.getEnclosedPage();
				if((""+framepage.getUrl()).indexOf("frame_left")>-1)
				{
					leftpage = framepage;
				}else if((""+framepage.getUrl()).indexOf("frame_right")>-1)
				{
					rightpage = framepage;
				}
			}
			
			
			if(leftpage!=null)
			{
				System.out.println(">>>>>>>>>>>>>>>>.left window:"+leftpage.getUrl()+","+leftpage.getLocalName());
			}
			if(rightpage!=null)
			{
				System.out.println(">>>>>>>>>>>>>>>>.right window:"+rightpage.getUrl()+","+rightpage.getLocalName());
			}
			leftpage.executeJavaScript("turn('interface/interface.html','u2-8')");
			
			wws = webClient.getWebWindows();
			WebWindow rightWindow = null;
			for (WebWindow ww : wws)
			{
				HtmlPage framepage = (HtmlPage)ww.getEnclosedPage();
				System.out.println("+++++++++++++++.right window:"+framepage.getUrl());
				if((""+framepage.getUrl()).indexOf("interface.html")>-1)
				{
					rightWindow = ww;
					rightpage = framepage;
				}
			}
			if(rightpage!=null)
			{
				System.out.println(">>>>>>>>>>>>>>>>.right window:"+rightpage.getUrl()+","+rightpage.getLocalName());
			}
			System.out.println(">>>>>>>>>>>>>>>>.right text:"+rightpage.asXml());
			HtmlTable table =null;
			if(rightpage.getElementById("table1")!=null)
			{
				table = (HtmlTable)rightpage.getElementById("table11");
			}
			List<HtmlTableRow>	rows = table.getRows() ;
			System.out.println("row size:"+rows.size());
			for(HtmlTableRow row:rows)
			{
				List<HtmlTableCell>	cells = row.getCells() ;
				for(HtmlTableCell cell:cells)
				{
					System.out.print("\t"+cell.asText());
				}
				System.out.print("\n");
			}
			//
			ScriptResult sr = rightpage.executeJavaScript("page(this,'flowmeter_main.html')");
			rightpage = (HtmlPage)rightWindow.getEnclosedPage();
			if(rightpage!=null)
			{
				System.out.println("\t page:"+rightpage.getUrl()+"\n"+rightpage.asXml());
			}
			table =null;
			if(rightpage.getElementById("newTable")!=null)
			{
				table = (HtmlTable)rightpage.getElementById("newTable");
			}
			rows = table.getRows() ;
			System.out.println("row size:"+rows.size());
			for(HtmlTableRow row:rows)
			{
				List<HtmlTableCell>	cells = row.getCells() ;
				for(HtmlTableCell cell:cells)
				{
					System.out.print("\t"+cell.asText());
				}
				System.out.print("\n");
			}
			
			
			//select a checkbox ,and click
			 List<DomElement>  cks = rightpage.getElementsByName("chk");
			 HtmlCheckBoxInput check = null;
			System.out.println("check size:" + cks.size());
			for (DomElement ck : cks)
			{
				check = (HtmlCheckBoxInput)ck;
				if(("" + check).indexOf("19:Ethernet0") != -1)
				{
					check.click();
				}
					//if (("" + ck).indexOf("value=\"Login\" class=\"log_button\"") != -1)
				{
					System.out.println("check :" + ck);
					//HtmlButtonInput button = (HtmlButtonInput) de;
				}
			}
			
			sr = rightpage.executeJavaScript("detail();");
			System.out.println("\n\n----"+((HtmlPage)sr.getNewPage()).asText());
			
			//HtmlPasswordInput InputPassword = (HtmlPasswordInput) page.getElementById("password");

			//InputUserName.setText("閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷锋病閿熸枻鎷烽敓锟�");

			//InputPassword.setText("閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷");

			//HtmlButton hb = (HtmlButton) page.getElementById("login");

			//hb.click();
			//閿熸枻鎷峰綍閿熺獤鎾呮嫹閿熺即鐧告嫹閿熸枻鎷烽敓鏂ゆ嫹閿熺殕杈炬嫹鍗伴〉閿熸枻鎷蜂负xml閿熶茎纭锋嫹4閿熷彨璁规嫹閿熻鍑ゆ嫹閿熼摪纭锋嫹閿熼ズ锟� 
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Logger logger = Logger.getAnonymousLogger();
		logger.setLevel(Level.ALL);
		new SwLogin().login();
	}

}

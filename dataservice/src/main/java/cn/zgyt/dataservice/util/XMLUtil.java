package cn.zgyt.dataservice.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.zgyt.dataservice.entity.ColumnDefine;
import cn.zgyt.dataservice.entity.TableDefine;

public class  XMLUtil{
	
    public static void main(String[] args) {
        try {
//        	createXml();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Node selectSingleNode(String express, Object source) {//查找节点，并返回第一个符合条件节点
        Node result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(Node) xpath.evaluate(express, source, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static NodeList selectNodes(String express, Object source) {//查找节点，返回符合条件的节点集。
        NodeList result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(NodeList) xpath.evaluate(express, source, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     *	生成删除表xml
     */
    public static String createDelXml(String filePath,String tableName) throws Exception {
		File file = new File(filePath);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		db = factory.newDocumentBuilder();
		Document d = db.newDocument();
		Element parentTag = createParentTag(d);
		Element dropTable = d.createElement("dropTable");
		dropTable.setAttribute("tableName", tableName);
		Element changeSet = d.createElement("changeSet");
		changeSet.setAttribute("id", "init-schema");
		changeSet.setAttribute("author", "tianshouzhi");
		changeSet.appendChild(dropTable);
		
		parentTag.appendChild(changeSet);
		d.appendChild(parentTag);
		saveXml(filePath, d);
		return null;//将Document输出到文件
    }
    
    
    /**
     *	生成创建表动作xml
     */
    public static String parseTableDefineToXml(String filePath,TableDefine td) throws Exception {//将Document输出到文件
    	List<ColumnDefine> cdL = td.getColumnDefineList();
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		db = factory.newDocumentBuilder();
		Document d = db.newDocument();
		//parentTag
		Element parentTag = createParentTag(d);
		//changeSet
		Element changeSet = d.createElement("changeSet");
		changeSet.setAttribute("id", "init-schema");
		changeSet.setAttribute("author", "tianshouzhi");
		//comment
		Element comment = d.createElement("comment");
		comment.setTextContent("init schema");
		//createTable
		Element createTable = d.createElement("createTable");
		createTable.setAttribute("tableName", td.getTableName());
		
		Element id = createColumn(JsonSqlUtil.getPrimarykeyInfo(), d);
		createTable.appendChild(id);
		for (int i = 0; i < cdL.size(); i++) {
			ColumnDefine cd = cdL.get(i);
			Element column = createColumn(cd, d);
			createTable.appendChild(column);
		}
		changeSet.appendChild(comment);
		changeSet.appendChild(createTable);
		parentTag.appendChild(changeSet);
		d.appendChild(parentTag);
		saveXml(filePath, d);
		return null;
    }
    
    /**
     * 	创建父级标签
     * 	创建表动作
     */
    private static Element createParentTag(Document d) {
    	Element databaseChangeLog = d.createElement("databaseChangeLog");
    	databaseChangeLog.setAttribute("xmlns", "http://www.liquibase.org/xml/ns/dbchangelog");
    	databaseChangeLog.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
    	databaseChangeLog.setAttribute("xsi:schemaLocation", "http://www.liquibase.org/xml/ns/dbchangelog \r\n" + 
    			"http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.4.xsd");
		return databaseChangeLog;
	}

	/**
     *   创建Column及其子标签
     *   创建表动作
     */
    public static Element createColumn(ColumnDefine cd, Document d) {
    	Element column = d.createElement("column");
    	Element constraints = d.createElement("constraints");
    	column.setAttribute("name", cd.getColumnName());
    	if(cd.getColumnClass().equals("varchar")) {
			if(cd.getColumnName().equals("id")) {
//				column.setAttribute("autoIncrement", cd.getColumnClass()+"("+cd.getColumnLength()+")");
				constraints.setAttribute("nullable","false");
				constraints.setAttribute("primaryKey","true");
			}else {
				constraints.setAttribute("nullable","true");
			}
			if(cd.getColumnLength()==null) {
				column.setAttribute("type", cd.getColumnClass()+"(255)");
			}else {
				column.setAttribute("type", cd.getColumnClass()+"("+cd.getColumnLength()+")");
			}
//	    	constraints.setAttribute("nullable","false");
		}else{
			column.setAttribute("type", cd.getColumnClass());
			constraints.setAttribute("nullable","true");
		}
    	column.appendChild(constraints);
		return column;
    }
    
    /**
     * 	生成xml文件
     */
    public static void saveXml(String fileName, Document doc) {//将Document输出到文件
        TransformerFactory transFactory=TransformerFactory.newInstance();
        FileOutputStream f=null;
        try {
        	f= new FileOutputStream(fileName);
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source=new DOMSource();
            source.setNode(doc);
            StreamResult result=new StreamResult();
            result.setOutputStream(f);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }   
        finally {
        	try {
				f.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        
    }
    
    /**
	 * 生成xml方法
	 * test
	 */
	public static void createTestXml(){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			Document d = db.newDocument();
			// 不显示standalone="no"
			d.setXmlStandalone(true);
			
			Element changeSet = d.createElement("changeSet");
			changeSet.setAttribute("id", "init-schema");
			changeSet.setAttribute("author", "tianshouzhi");
			
			Element createTable = d.createElement("createTable");
			createTable.setAttribute("tableName", "user1");
			
			Element column = d.createElement("column");
			column.setAttribute("name", "id");
			column.setAttribute("type", "bigint");
			column.setAttribute("autoIncrement", "${autoIncrement}");
			
			Element constraints = d.createElement("constraints");
			column.setAttribute("primaryKey", "true");
			column.setAttribute("nullable", "false");

			column.appendChild(constraints);
			createTable.appendChild(column);
			changeSet.appendChild(createTable);
			d.appendChild(changeSet);
			System.out.println("生成xml文件成功");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public static void delXmlByPath(String filePath) {
		TransformerFactory transFactory=TransformerFactory.newInstance();
		File file = new File(filePath);
		if(file.exists()) {
			file.delete();
		}
	}
}

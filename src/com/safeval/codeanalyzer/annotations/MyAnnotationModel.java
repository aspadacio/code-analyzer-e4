/**
 * 
 */
package com.safeval.codeanalyzer.annotations;

import java.util.Iterator;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelListener;

/**
 * @author Spadacio
 *
 */
public class MyAnnotationModel implements IAnnotationModel {

	/**
	 * 
	 */
	public MyAnnotationModel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addAnnotationModelListener(IAnnotationModelListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAnnotationModelListener(IAnnotationModelListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void connect(IDocument document) {
		// TODO Auto-generated method stub

	}

	@Override
	public void disconnect(IDocument document) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAnnotation(Annotation annotation, Position position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAnnotation(Annotation annotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Annotation> getAnnotationIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position getPosition(Annotation annotation) {
		// TODO Auto-generated method stub
		return null;
	}

}

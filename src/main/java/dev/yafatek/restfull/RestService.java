package dev.yafatek.restfull;import java.util.List;/** * Interface to Perform the Main Rest Operations * GET,POST,PATCH,PUT and DELETE * * @param <T> Type to Entity to perform Operations On */public interface RestService<T> {	/**	 * Show all results inside the Table	 *	 * @return List of Type T	 */	List<T> indexAll();	/**	 * Perform Get request to Fetch One Object	 *	 * @param param query param {requestId}	 * @return Object of Type T	 */	T indexOne(Object param);	/**	 * perform get request to Fetch all Data inside a table.	 *	 * @return List of object of type T	 */	List<T> showAll();	/**	 * perform Bulk Delete on Table	 *	 * @return Object that deleted of Type T	 */	T deleteAll();	/**	 * perform Delete request on a resource	 *	 * @param params {resourceId} the id of the resource to delete	 * @return	 */	T deleteOne(Object params);	/**	 * perform bulk update on table	 *	 * @return List of updated columns	 */	List<T> updateAll();	/**	 * perform update on a resource.	 *	 * @param params {resourceId} the id of the resource in DB	 * @return Object of type T that have been deleted.	 */	T updateOne(Object params);}
/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.rest.api.task;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.task.Task;
import org.activiti.rest.api.AbstractPaginateList;
import org.activiti.rest.api.RestResponseFactory;
import org.activiti.rest.api.SecuredResource;
import org.activiti.rest.application.ActivitiRestServicesApplication;

/**
 * @author Frederik Heremans
 */
public class TaskPaginateList extends AbstractPaginateList {

  private SecuredResource resource;
  
  public TaskPaginateList(SecuredResource resource) {
    this.resource = resource;
  }
  
  @SuppressWarnings("rawtypes")
  @Override
  protected List processList(List list) {
    List<TaskResponse> responseList = new ArrayList<TaskResponse>();
    RestResponseFactory restResponseFactory = resource.getApplication(ActivitiRestServicesApplication.class).getRestResponseFactory();
    for (Object task : list) {
      responseList.add(restResponseFactory.createTaskReponse(resource, (Task) task));
    }
    return responseList;
  }
}
/*
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.plugin.maven.client.command;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import com.google.gwtmockito.GwtMockitoTestRunner;
import java.util.Collection;
import org.eclipse.che.ide.api.command.CommandPage;
import org.eclipse.che.ide.api.icon.IconRegistry;
import org.eclipse.che.ide.macro.CurrentProjectPathMacro;
import org.eclipse.che.plugin.maven.client.MavenResources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/** @author Artem Zatsarynnyi */
@RunWith(GwtMockitoTestRunner.class)
public class MavenCommandTypeTest {

  @Mock private MavenResources mavenResources;
  @Mock private MavenCommandPagePresenter mavenCommandPagePresenter;
  @Mock private CurrentProjectPathMacro currentProjectPathMacro;
  @Mock private IconRegistry iconRegistry;

  @InjectMocks private MavenCommandType mavenCommandType;

  @Test
  public void shouldReturnPages() throws Exception {
    final Collection<CommandPage> pages = mavenCommandType.getPages();

    assertTrue(pages.contains(mavenCommandPagePresenter));
  }

  @Test
  public void testGettingCommandTemplate() throws Exception {
    mavenCommandType.getCommandLineTemplate();

    verify(currentProjectPathMacro).getName();
  }
}
